package com.hand.api.controller.v1;

import com.hand.api.controller.dto.OrderReturnDTO;
import com.hand.app.service.OrderService;
import com.hand.app.service.SoLineService;
import com.hand.config.SwaggerApiConfig;
import com.hand.domain.entity.Conditions;
import com.hand.domain.entity.Order;
import com.hand.domain.entity.SoLine;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.boot.platform.lov.annotation.ProcessLovValue;
import org.hzero.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 关于Order订单的相关API的Controller类
 */
@Api(tags = SwaggerApiConfig.ORDER)
@RestController("orderController.v1")
@RequestMapping("/v1/{organizationId}/order")
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private SoLineService soLineService;

    /**
     * 根据条件查询订单汇总
     *
     * @param pageRequest 分页请求
     * @param conditions  查询条件
     * @return 分页结果集
     */
    @ApiOperation(value = "根据条件查询订单汇总")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/list")
    @ProcessLovValue()
    public Page<OrderReturnDTO> list(@PathVariable Long organizationId,
                                     PageRequest pageRequest,
                                     Conditions conditions) {
        return orderService.list(pageRequest, conditions);
    }


    /**
     * @param pageRequest 分页请求
     * @param headerId    头ID
     * @return 查询到的订单行信息
     */
    @ApiOperation(value = "根据订单头ID查询对应的订单行信息")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/listLine")
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
    @DeleteMapping("/deleteLine")
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
    @DeleteMapping("/deleteId")
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
    @PostMapping("/addOrder")
    public Order addOrder(@PathVariable Long organizationId,
                          @RequestBody Order order) {
        return orderService.addOrder(organizationId, order);
    }

}
