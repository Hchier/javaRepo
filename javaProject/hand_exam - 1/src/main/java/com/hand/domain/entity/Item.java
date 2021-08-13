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

import java.util.Date;


@ApiModel("")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_item")
public class Item extends AuditDomain {

    public static final String FIELD_ITEM_ID = "itemId";
    public static final String FIELD_ITEM_CODE = "itemCode";
    public static final String FIELD_ITEM_UOM = "itemUom";
    public static final String FIELD_ITEM_DESCRIPTION = "itemDescription";
    public static final String FIELD_SALEABLE_FLAG = "saleableFlag";
    public static final String FIELD_START_ACTIVE_DATE = "startActiveDate";
    public static final String FIELD_END_ACTIVE_DATE = "endActiveDate";
    public static final String FIELD_ENABLED_FLAG = "enabledFlag";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long itemId;
    @ApiModelProperty(value = "",required = true)
    @NotBlank
    private String itemCode;
    @ApiModelProperty(value = "",required = true)
    @NotBlank
    private String itemUom;
    @ApiModelProperty(value = "",required = true)
    @NotBlank
    private String itemDescription;
    @ApiModelProperty(value = "",required = true)
    @NotNull
    private Integer saleableFlag;
   @ApiModelProperty(value = "")    
    private Date startActiveDate;
   @ApiModelProperty(value = "")    
    private Date endActiveDate;
    @ApiModelProperty(value = "",required = true)
    @NotNull
    private Integer enabledFlag;

	//
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

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
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
    /**
     * @return 
     */
	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}
    /**
     * @return 
     */
	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
    /**
     * @return 
     */
	public Integer getSaleableFlag() {
		return saleableFlag;
	}

	public void setSaleableFlag(Integer saleableFlag) {
		this.saleableFlag = saleableFlag;
	}
    /**
     * @return 
     */
	public Date getStartActiveDate() {
		return startActiveDate;
	}

	public void setStartActiveDate(Date startActiveDate) {
		this.startActiveDate = startActiveDate;
	}
    /**
     * @return 
     */
	public Date getEndActiveDate() {
		return endActiveDate;
	}

	public void setEndActiveDate(Date endActiveDate) {
		this.endActiveDate = endActiveDate;
	}
    /**
     * @return 
     */
	public Integer getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(Integer enabledFlag) {
		this.enabledFlag = enabledFlag;
	}

}
