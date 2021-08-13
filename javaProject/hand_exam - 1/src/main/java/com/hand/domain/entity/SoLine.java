package com.hand.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import io.choerodon.mybatis.domain.AuditDomain;
import java.math.BigDecimal;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_so_line")
public class SoLine extends AuditDomain {

    public static final String FIELD_SO_LINE_ID = "soLineId";
    public static final String FIELD_SO_HEADER_ID = "soHeaderId";
    public static final String FIELD_LINE_NUMBER = "lineNumber";
    public static final String FIELD_ITEM_ID = "itemId";
    public static final String FIELD_ORDER_QUANTITY = "orderQuantity";
    public static final String FIELD_ORDER_QUANTITY_UOM = "orderQuantityUom";
    public static final String FIELD_UNIT_SELLING_PRICE = "unitSellingPrice";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_ADDITION1 = "addition1";
    public static final String FIELD_ADDITION2 = "addition2";
    public static final String FIELD_ADDITION3 = "addition3";
    public static final String FIELD_ADDITION4 = "addition4";
    public static final String FIELD_ADDITION5 = "addition5";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long soLineId;
    @ApiModelProperty(value = "",required = true)
    @NotNull
    private Long soHeaderId;
    @ApiModelProperty(value = "",required = true)
    @NotNull
    private Long lineNumber;
    @ApiModelProperty(value = "",required = true)
    @NotNull
    private Long itemId;
    @ApiModelProperty(value = "",required = true)
    @NotNull
    private BigDecimal orderQuantity;
    @ApiModelProperty(value = "",required = true)
    @NotBlank
    private String orderQuantityUom;
    @ApiModelProperty(value = "",required = true)
    @NotNull
    private BigDecimal unitSellingPrice;
   @ApiModelProperty(value = "")    
    private String description;
   @ApiModelProperty(value = "")    
    private String addition1;
   @ApiModelProperty(value = "")    
    private String addition2;
   @ApiModelProperty(value = "")    
    private String addition3;
   @ApiModelProperty(value = "")    
    private String addition4;
   @ApiModelProperty(value = "")    
    private String addition5;

	//
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 
     */
	public Long getSoLineId() {
		return soLineId;
	}

	public void setSoLineId(Long soLineId) {
		this.soLineId = soLineId;
	}
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
	public Long getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Long lineNumber) {
		this.lineNumber = lineNumber;
	}
    /**
     * @return 
     */
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
    /**
     * @return 
     */
	public BigDecimal getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(BigDecimal orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
    /**
     * @return 
     */
	public String getOrderQuantityUom() {
		return orderQuantityUom;
	}

	public void setOrderQuantityUom(String orderQuantityUom) {
		this.orderQuantityUom = orderQuantityUom;
	}
    /**
     * @return 
     */
	public BigDecimal getUnitSellingPrice() {
		return unitSellingPrice;
	}

	public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}
    /**
     * @return 
     */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    /**
     * @return 
     */
	public String getAddition1() {
		return addition1;
	}

	public void setAddition1(String addition1) {
		this.addition1 = addition1;
	}
    /**
     * @return 
     */
	public String getAddition2() {
		return addition2;
	}

	public void setAddition2(String addition2) {
		this.addition2 = addition2;
	}
    /**
     * @return 
     */
	public String getAddition3() {
		return addition3;
	}

	public void setAddition3(String addition3) {
		this.addition3 = addition3;
	}
    /**
     * @return 
     */
	public String getAddition4() {
		return addition4;
	}

	public void setAddition4(String addition4) {
		this.addition4 = addition4;
	}
    /**
     * @return 
     */
	public String getAddition5() {
		return addition5;
	}

	public void setAddition5(String addition5) {
		this.addition5 = addition5;
	}

}
