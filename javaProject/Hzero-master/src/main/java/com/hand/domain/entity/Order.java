package com.hand.domain.entity;

import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class Order extends AuditDomain {

    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long soHeaderId;
    @ApiModelProperty(value = "",required = true)
    @NotBlank
    private String orderNumber;
    @ApiModelProperty(value = "",required = true)
    @NotNull
    private Long companyId;
    @ApiModelProperty(value = "",required = true)
    @NotNull
    private Date orderDate;
    @ApiModelProperty(value = "",required = true)
    @NotBlank
    private String orderStatus;
    @ApiModelProperty(value = "",required = true)
    @NotNull
    private Long customerId;
    @ApiModelProperty(value = "", required = true)
    @NotNull
    private List<SoLine> list;

    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<SoLine> getList() {
        return list;
    }

    public void setList(List<SoLine> list) {
        this.list = list;
    }
}
