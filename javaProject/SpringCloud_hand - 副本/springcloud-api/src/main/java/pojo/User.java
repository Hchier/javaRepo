//package pojo;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
//
//import java.io.Serializable;
//
//@Data
//
//@Accessors(chain = true) //链式写法
//
//public class User implements Serializable {
//    //所有的实体类必须实现序列化Serializable，否则传输会报错
//    private String username;
//    private String password;
//    //微服务，一个服务对应一个数据库，同一信息可能存在于不同的数据库
//    private String dbname;
//    public User(){
//
//    }
//    public User(String username,String password,String dbname){
//        this.username=username;
//        this.password=password;
//        this.dbname=dbname;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getDbname() {
//        return dbname;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setDbname(String dbname) {
//        this.dbname = dbname;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", dbname='" + dbname + '\'' +
//                '}';
//    }
//}
