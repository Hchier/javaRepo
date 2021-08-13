package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
//@AllArgsConstructor
@NoArgsConstructor
public class hand_departments implements Serializable {
    String department_id;
    String department_code;
    String department_name;
    String manager_id;
    String location_id;

    public hand_departments(String department_id, String department_code, String department_name, String manager_id, String location_id) {
        this.department_id = department_id;
        this.department_code = department_code;
        this.department_name = department_name;
        this.manager_id = manager_id;
        this.location_id = location_id;

    }

    public void setDepartment_code(String department_code) {
        this.department_code = department_code;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    public String getDepartment_code() {
        return department_code;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public String getLocation_id() {
        return location_id;
    }

    public String getManager_id() {
        return manager_id;
    }
}
