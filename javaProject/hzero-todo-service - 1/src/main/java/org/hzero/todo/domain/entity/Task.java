package org.hzero.todo.domain.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import org.springframework.data.annotation.Transient;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@ApiModel("任务信息")
@ModifyAudit
@VersionAudit
@Table(name = "todo_task")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task extends AuditDomain {
    public static final String FIELD_ID = "id";
    public static final String FIELD_EMPLOYEE_ID = "employeeId";
    public static final String FIELD_STATE = "state";
    public static final String FIELD_TASK_DESCRIPTION = "taskDescription";
    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "用户ID不能为空")
    @ApiModelProperty("用户ID")
    private Long employeeId;
    @ApiModelProperty("任务状态")
    private String state;
    @ApiModelProperty("任务编号")
    private String taskNumber;
    @Length(max = 240)
    @ApiModelProperty("任务描述")
    private String taskDescription;
    @NotNull
    @ApiModelProperty("租户ID")
    private Long tenantId;
    @Transient
    @ApiModelProperty("员工编号")
    private String employeeNumber;
    @Transient
    @ApiModelProperty("员工姓名")
    private String employeeName;
    /**
     * 生成任务编号
     */
    public void generateTaskNumber() {
        this.taskNumber = UUID.randomUUID().toString().replace("-", "");
    }
    // 省略 getter/setter

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public Long getId() {
        return id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getState() {
        return state;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    @Override
    public Date getCreationDate() {
        return super.getCreationDate();
    }

    @Override
    public Date getLastUpdateDate() {
        return super.getLastUpdateDate();
    }

    @Override
    public Long getCreatedBy() {
        return super.getCreatedBy();
    }

    @Override
    public Long getLastUpdatedBy() {
        return super.getLastUpdatedBy();
    }

    @Override
    public Long getObjectVersionNumber() {
        return super.getObjectVersionNumber();
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public AuditDomain set_innerMap(Map<String, Object> _innerMap) {
        return super.set_innerMap(_innerMap);
    }

    @Override
    public AuditDomain set_status(RecordStatus _status) {
        return super.set_status(_status);
    }

    @Override
    public AuditDomain set_tls(Map<String, Map<String, String>> _tls) {
        return super.set_tls(_tls);
    }

    @Override
    public AuditDomain setFlex(Map<String, Object> flex) {
        return super.setFlex(flex);
    }

    @Override
    public void set_innerMap(String key, Object value) {
        super.set_innerMap(key, value);
    }

    @Override
    public void set_token(String _token) {
        super.set_token(_token);
    }

    @Override
    public void setCreatedBy(Long createdBy) {
        super.setCreatedBy(createdBy);
    }

    @Override
    public void setCreationDate(Date creationDate) {
        super.setCreationDate(creationDate);
    }

    @Override
    public void setLastUpdateDate(Date lastUpdateDate) {
        super.setLastUpdateDate(lastUpdateDate);
    }

    @Override
    public void setLastUpdatedBy(Long lastUpdatedBy) {
        super.setLastUpdatedBy(lastUpdatedBy);
    }

    @Override
    public void setObjectVersionNumber(Long objectVersionNumber) {
        super.setObjectVersionNumber(objectVersionNumber);
    }

    @Override
    public void setTableId(String tableId) {
        super.setTableId(tableId);
    }
}