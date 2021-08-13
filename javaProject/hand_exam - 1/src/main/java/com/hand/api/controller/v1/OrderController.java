package com.hand.api.controller.v1;

import com.hand.api.controller.dto.OrderReturnDTO;
import com.hand.app.service.OrderService;
import com.hand.app.service.SoLineService;
import com.hand.config.SwaggerApiConfig;
import com.hand.domain.entity.*;
import com.hand.domain.repository.SoHeaderRepository;
import com.hand.domain.repository.SoLineRepository;
import com.hand.infra.mapper.SoHeaderMapper;
import com.hand.infra.mapper.SoLineMapper;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.boot.platform.lov.annotation.ProcessLovValue;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = SwaggerApiConfig.ORDER)
@RestController("orderController.v1")
//@RequestMapping("/v1/{organizationId}/order")
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private SoLineService soLineService;
    @Autowired
    private SoHeaderMapper soHeaderMapper;
    @Autowired
    private SoLineMapper soLineMapper;

    @Autowired
    private SoHeaderRepository soHeaderRepository;
    @Autowired
    private SoLineRepository soLineRepository;

    /**
     * 根据条件查询订单汇总
     *
     * @param pageRequest 分页请求
     * @param conditions  查询条件
     * @return 分页结果集
     */
    @ApiOperation(value = "订单汇总查询API")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/{organizationId}/so-headers")
    @ProcessLovValue()
    public Page<OrderReturnDTO> list(@PathVariable Long organizationId,
                                     PageRequest pageRequest,
                                     Conditions conditions) {
        return orderService.list(pageRequest, conditions);
    }

    @ApiOperation(value = "订单删除API")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping("/v1/{organizationId}/so-headers")
    public ResponseEntity<?> remove(@PathVariable Long organizationId,@RequestBody SoHeader soHeader) {
//
        soLineRepository.deleteBySoHeaderId(soHeader.getSoHeaderId());
        soHeaderRepository.deleteById(soHeader.getSoHeaderId());
        //orderService.deleteOrder(organizationId, soHeader.getSoHeaderId());
        return Results.success("");
    }


    @ApiOperation(value = "订单保存API")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/v1/{organizationId}/so-headers")
    public ResponseEntity<Order> orderSave(@PathVariable Long organizationId,
                                           @RequestBody Order order) {


//        for (SoLine soLine : order.getList()){
//            soLineRepository.insertSelective(soLine);
//        }
//
//        SoHeader soHeader=new SoHeader();
//        soHeader.setSoHeaderId(order.getSoHeaderId());
//        soHeader.setOrderNumber(order.getOrderNumber());
//        soHeader.setCompanyId(order.getCompanyId());
//        soHeader.setOrderStatus(order.getOrderStatus());
//        soHeader.setCustomerId(order.getCustomerId());
//        soHeaderRepository.insertInfo(soHeader);
        return Results.success(orderService.addOrder(organizationId, order));
    }



//    @ApiOperation(value = "订单保存API")
//    @Permission(level = ResourceLevel.SITE)
//    @PostMapping("/v1/{organizationId}/so-headers/addOrder")
//    public ResponseEntity<Order> addOrder(@PathVariable Long organizationId,
//                                           @RequestBody Order order) {
//
//    }

//    @ApiOperation(value = "汇总查询")
//    @Permission(level = ResourceLevel.SITE)
//    @GetMapping("/orderSummaryQuery")
//    public ResponseEntity<?> orderSummaryQuery(@PathVariable Long organizationId,
//                                               PageRequest pageRequest,
//                                               Conditions conditions) {
//        return Results.success("hi");
//    }

    /**
     * @param pageRequest 分页请求
     * @param headerId    头ID
     * @return 查询到的订单行信息
     */
    @ApiOperation(value = "根据订单头ID查询对应的订单行信息")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/v1/{organizationId}/order/listLine")
    public Page<SoLine> listLine(@PathVariable Long organizationId,
                                 PageRequest pageRequest,
                                 @RequestParam Long headerId) {
        Page<SoLine> list = PageHelper.doPageAndSort(pageRequest, () -> soLineService.selectById(headerId));
        return list;
    }

    /**
     * @param soheaderid 订单头ID
     */
    @ApiOperation(value = "根据订单头ID删除订单行信息")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping("/v1/{organizationId}/order/deleteLine")
    public void deleteLine(@PathVariable Long organizationId,
                           Long soheaderid) {
        orderService.deleteLineByHeadId(organizationId, soheaderid);
    }




    /**
     * 根据订单头ID删除订单
     *
     * @param soHeaderId 订单头
     * @return 返回结果String
     */
    @ApiOperation(value = "根据订单头ID删除订单")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping("/v1/{organizationId}/order/deleteId")
    public ResponseEntity<String> deleteId(@PathVariable Long organizationId,
                                           Long soHeaderId) {
        return orderService.deleteOrder(organizationId, soHeaderId);
    }


    /**
     * 添加相应的订单头和订单行
     *
     * @param order 待添加订单信息
     * @return 返回加入/更新结果的entity
     */
    @ApiOperation(value = "添加相应的订单头和订单行")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/v1/{organizationId}/order/addOrder")
    public Order addOrder(@PathVariable Long organizationId,
                          @RequestBody Order order) {
        return orderService.addOrder(organizationId, order);
    }



}
