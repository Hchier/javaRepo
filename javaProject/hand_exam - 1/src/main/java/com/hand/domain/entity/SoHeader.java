package com.hand.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import io.choerodon.mybatis.domain.AuditDomain;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;


@ApiModel("")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_so_header")
@Getter
@ToString
public class SoHeader extends AuditDomain {

    public static final String FIELD_SO_HEADER_ID = "soHeaderId";
    public static final String FIELD_ORDER_NUMBER = "orderNumber";
    public static final String FIELD_COMPANY_ID = "companyId";
    public static final String FIELD_ORDER_DATE = "orderDate";
    public static final String FIELD_ORDER_STATUS = "orderStatus";
    public static final String FIELD_CUSTOMER_ID = "customerId";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


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
    //@NotNull
    private LocalDate orderDate;
    @ApiModelProperty(value = "",required = true)
    @NotBlank
    private String orderStatus;
    //private String orderStatusMeaning;
    @ApiModelProperty(value = "",required = true)
    @NotNull
    private Long customerId;

	//
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 
     */
	public Long getSoHeaderId() {
		return soHeaderId;
	}

	public void setSoHeaderId(Long soHeaderId) {
		this.soHeaderId = soHeaderId;
	}
    /**
     * @return 
     */
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
    /**
     * @return 
     */
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
    /**
     * @return 
     */
	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
    /**
     * @return 
     */
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
    /**
     * @return 
     */
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

}
