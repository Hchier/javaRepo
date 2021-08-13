package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class hand_employees implements Serializable {
    String employee_id;
    String employee_num;
    String first_name;
    String last_name;
    String sex;
    String phone_num;
    String email;
    String hire_date;
    String department_id;
    String status_code;

    public String getDepartment_id() {
        return department_id;
    }

    public String getEmail() {
        return email;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public String getEmployee_num() {
        return employee_num;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getHire_date() {
        return hire_date;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public String getSex() {
        return sex;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public void setEmployee_num(String employee_num) {
        this.employee_num = employee_num;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
}
