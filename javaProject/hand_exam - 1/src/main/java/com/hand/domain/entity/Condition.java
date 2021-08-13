package com.hand.domain.entity;

import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 订单查询条件
 *
 */
@ApiModel("订单查询条件")
public class Condition extends AuditDomain {

    @ApiModelProperty(value = "公司id")
    private Long  companyId;
    @ApiModelProperty(value = "客户id")
    private Long customerId;
    @ApiModelProperty(value = "订单编号")
    private String orderNumber;
    //@ApiModelProperty(value = "物料id")
    //private Long itemId;
    @ApiModelProperty(value = "订单状态")
    private String orderStatus;

    public Condition(Long companyId, Long customerId, String orderNumber, String orderStatus){
        this.companyId = companyId;
        this.customerId = customerId;
        this.orderNumber = orderNumber;
        //this.itemId = itemId;
        this.orderStatus = orderStatus;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    //public Long getItemId() {
//        return itemId;
//    }
//
//    public void setItemId(Long itemId) {
//        this.itemId = itemId;
//    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "companyId=" + companyId +
                ", customerId=" + customerId +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
