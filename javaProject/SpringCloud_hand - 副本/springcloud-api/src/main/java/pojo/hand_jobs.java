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
public class hand_jobs implements Serializable{
    String job_id;
    String job_code;
    String job_name;
    String primary_flag;
    String enabled_flag;
    String employee_id;

}
