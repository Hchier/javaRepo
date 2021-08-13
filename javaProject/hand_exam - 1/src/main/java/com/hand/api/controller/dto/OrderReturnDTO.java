package com.hand.api.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hzero.core.base.BaseConstants;
import org.hzero.boot.platform.lov.annotation.LovValue;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Pattern;


public class OrderReturnDTO implements BaseConstants {


	@ApiModelProperty(value = "头id")
	private String soHeaderId;

	@ApiModelProperty(value = "订单编号")
	//@LovValue(lovCode = "HZERO.ORDER.NUMBER" , meaningField = "orderNumber")
	private String orderNumber;
	@ApiModelProperty(value = "公司名称")
	private String companyName;
	@ApiModelProperty(value = "客户名称")
	private String customerName;
	@ApiModelProperty(value = "订单日期" )
	@javax.validation.constraints.Pattern(regexp = Pattern.DATE)
	private Date orderDate;

	private String a;
	@ApiModelProperty(value = "订单状态")
	@LovValue(lovCode = "HZERO.ORDER.STATUS" , meaningField = "a")

	private String orderStatus;
	@ApiModelProperty(value = "订单行金额")
	private BigDecimal lineAmount;
	@ApiModelProperty(value = "订单总金额")
	private BigDecimal orderAmount;
	@ApiModelProperty(value = "数量")
	private BigDecimal orderQuantity;
	@ApiModelProperty(value = "销售单价")
	private BigDecimal unitSellingPrice;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public BigDecimal getLineAmount() {
		return lineAmount;
	}

	public void setLineAmount(BigDecimal lineAmount) {
		this.lineAmount = lineAmount;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(BigDecimal orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public BigDecimal getUnitSellingPrice() {
		return unitSellingPrice;
	}

	public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}

	public String getSoHeaderId() {
		return soHeaderId;
	}

	public void setSoHeaderId(String soHeaderId) {
		this.soHeaderId = soHeaderId;
	}

	@Override
	public String toString() {
		return "OrderReturnDTO{" +
				"soHeaderId='" + soHeaderId + '\'' +
				", orderNumber='" + orderNumber + '\'' +
				", companyName='" + companyName + '\'' +
				", customerName='" + customerName + '\'' +
				", orderDate=" + orderDate +
				", a='" + a + '\'' +
				", orderStatus='" + orderStatus + '\'' +
				", lineAmount=" + lineAmount +
				", orderAmount=" + orderAmount +
				", orderQuantity=" + orderQuantity +
				", unitSellingPrice=" + unitSellingPrice +
				'}';
	}
}
