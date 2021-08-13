package pojo;

public class User {
    private String username;
    private String password;
    public User(){

    }
    public User(String username, String password){
        this.username = username;
        this.password=password;
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
