package com.hand.app.service.impl;

import com.hand.api.controller.dto.OrderReturnDTO;
import com.hand.app.service.OrderService;
import com.hand.app.service.SoLineService;
import com.hand.domain.entity.Conditions;
import com.hand.domain.entity.Order;
import com.hand.domain.entity.SoHeader;
import com.hand.domain.entity.SoLine;
import com.hand.domain.repository.SoHeaderRepository;
import com.hand.domain.repository.SoLineRepository;
import com.hand.infra.mapper.OrderMapper;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.core.base.BaseAppService;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl extends BaseAppService implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    private SoLineService soLineService;
    @Autowired
    SoHeaderRepository soHeaderRepository;
    @Autowired
    private SoLineRepository soLineRepository;
    @Autowired
    private CodeRuleBuilder codeRuleBuilder;

    private final String ORDERNUMBER = "HZERO.28263.ORDER.NUMBER";

    /**
     * 多条件分页查询
     * @param conditions 条件实体类
     * @return 分页结果集
     */
    @Override
    public Page<OrderReturnDTO> list(PageRequest pageRequest,Conditions conditions) {
        Page<OrderReturnDTO> page = PageHelper.doPageAndSort(pageRequest,() -> orderMapper.list(conditions));
        List<OrderReturnDTO> list = orderMapper.list(conditions);
        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        for (OrderReturnDTO orderReturnDTO:list) {
            if(map.containsKey(orderReturnDTO.getOrderNumber())){
                //通过Key值查询value值，value值不为空，代表为同一个订单，就把行金额相加
                map.put(orderReturnDTO.getOrderNumber(),map.get(orderReturnDTO.getOrderNumber()).add(orderReturnDTO.getLineAmount()));
            }else {
                //如果value为空代表还没有Map中的key值没有该Key值，就新增一个key值为订单编号,value值为行金额的的map
                map.put(orderReturnDTO.getOrderNumber(),orderReturnDTO.getLineAmount());//
            }
        }
        for (OrderReturnDTO orderReturnDTO:page.getContent()){
            //循环把订单的总金额放进对应每一个订单行数据中
            if(map.containsKey(orderReturnDTO.getOrderNumber())){
                orderReturnDTO.setOrderAmount(map.get(orderReturnDTO.getOrderNumber()));
            }
        }
        return page;
    }

    /**
     * 根据HeadId来删除Line
     * @param soheaderid 订单头ID
     */
    @Override
    public void deleteLineByHeadId(Long organizationId, Long soheaderid) {
        List<SoLine> list = soLineService.selectById(soheaderid);
        if (list == null) {
            throw new RuntimeException("输入的订单头没有相应的订单");
        }
        SoHeader soHeader1 = soHeaderRepository.selectByPrimaryKey(soheaderid);
        if (!soHeader1.getOrderStatus().equals("NEW") && !soHeader1.getOrderStatus().equals("REJECTED")) {
            throw new RuntimeException("订单状态不能修改");
        }
        if (list.size() != 0) {
            //遍历
            for (SoLine soLine : list) {
                SoLine soLine1 = soLineRepository.selectByPrimaryKey(soLine.getSoLineId());
                soLine.set_token(soLine1.get_token());
                soLine.setSoLineId(soLine.getSoLineId());
                SecurityTokenHelper.validToken(soLine);
                soLineRepository.deleteByPrimaryKey(soLine);
            }
        }
    }


    /**
     * 根据订单头删除订单
     * @param soHeaderId 订单头
     * @return 返回订单信息
     */
    @Override
    public ResponseEntity<String> deleteOrder(Long organizationId, Long soHeaderId) {
        List<SoLine> list = soLineService.selectById(soHeaderId);
        if (list == null) {
            throw new RuntimeException("输入的订单头没有相应的订单");
        }
        if (list.size() != 0) {
            //先删除订单行数据再删除订单头数据，否则只需要删除订单头数据
            for (SoLine soLine : list) {
                SoLine soLine1 = soLineRepository.selectByPrimaryKey(soLine.getSoLineId());
                soLine.set_token(soLine1.get_token());
                soLine.setSoLineId(soLine.getSoLineId());
                SecurityTokenHelper.validToken(soLine);
                soLineRepository.deleteByPrimaryKey(soLine);
            }
        }
        SoHeader soHeader1 = soHeaderRepository.selectByPrimaryKey(soHeaderId);
        SoHeader soHeader = new SoHeader();
        soHeader.set_token(soHeader1.get_token());
        soHeader.setObjectVersionNumber(soHeader1.getObjectVersionNumber());
        soHeader.setSoHeaderId(soHeaderId);
        SecurityTokenHelper.validToken(soHeader);
        soHeaderRepository.deleteByPrimaryKey(soHeader);
        return Results.success("删除订单成功");
    }

    @Override
    public Order addOrder(Long organizationId, Order order) {
        //如果order的SoHeaderId不为空
        if (order.getSoHeaderId() != null) {
            //当订单头不为空，表示更新订单头
            SoHeader soHeader = soHeaderRepository.selectByPrimaryKey(order.getSoHeaderId());
            if (order.getObjectVersionNumber() != null) {
                throw new RuntimeException("object_version_number为空");
            } else if (order.getObjectVersionNumber() != soHeader.getObjectVersionNumber()) {
                throw new RuntimeException("object_version_number不一致");
            } else {
                if ("NEW".equals(soHeader.getOrderStatus()) ||  "REJECTED".equals(soHeader.getOrderStatus())) {
                    soHeaderRepository.updateByPrimaryKeySelective(soHeader);
                }else {
                    throw new RuntimeException("当钱包订单状态无法更改");
                }
            }
        } else {
            //因为当soHeaderId为空的时候
            //将原order中对象中的关于SoHeader信息取出
            SoHeader soHeader = new SoHeader();
            //订单号按照编码规则生成并设置到soHeader
            String code = codeRuleBuilder.generateCode(ORDERNUMBER, null);
            soHeader.setOrderNumber(code);
            soHeader.setCompanyId(order.getCompanyId());
            soHeader.setOrderDate(order.getOrderDate());
            //使orderStatus默认是NEW
            if (order.getOrderStatus() != null) {
                soHeader.setOrderStatus(order.getOrderStatus());
            } else {
                soHeader.setOrderStatus("NEW");
            }
            soHeader.setCustomerId(order.getCustomerId());
            soHeader.set_token(order.get_token());
            //校验soHeader对象
            validObject(soHeader);
            //这个地方soHeaderId自动填充
            soHeaderRepository.insertSelective(soHeader);
            //将这个处理过得soHeader传递进orderResult
            order.setSoHeaderId(soHeader.getSoHeaderId());
            //insert有关SoLine
            List<SoLine> list = order.getList();
            int index = 0;
            for (SoLine soLine :
                    list) {
                //判断当前输入的soLine对象的soLineId是否为空，为空是添加，不为空是更新
                if(soLine.getSoLineId() != null){
                    SoLine soLine1 = soLineRepository.selectByPrimaryKey(soLine.getSoLineId());
                    //更新
                    if (soLine.getObjectVersionNumber() != null) {
                        if (soLine1.getObjectVersionNumber() == soLine.getObjectVersionNumber()){
                            soLineRepository.updateByPrimaryKey(soLine);
                            index++;
                        }else {
                            throw new RuntimeException("当前obejct_version_number不匹配");
                        }
                    }else {
                        throw new RuntimeException("当前obejct_version_number为空");
                    }
                }else {
                    //添加
                    soLine.setSoHeaderId(soHeader.getSoHeaderId());
                    validObject(soLine);
                    soLineRepository.insertSelective(soLine);
                    order.getList().get(index).setSoLineId(soLine.getSoLineId());
                    index++;
                }
            }
        }
        return order;
    }

}
