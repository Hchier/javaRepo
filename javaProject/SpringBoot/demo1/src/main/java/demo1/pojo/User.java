package demo1.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;


@Component
@ConfigurationProperties(prefix = "user1")//自动装配application.yaml中的user1
public class User {       // ConfigurationProperties支持松散绑定
    // userName对应yaml中的user-name
    //@Value("Hchier")
    private String userName;
    //@Value("pyh")
    private String password;
    @Email  // JSR303验证邮箱格式正确否。（加了跟没加一样）
    private String email;

    public User() {

    }

    public User(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
