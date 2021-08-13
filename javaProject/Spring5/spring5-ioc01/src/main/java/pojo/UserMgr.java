package pojo;

public class UserMgr {
    User user;
    public void setUser(User user) {
        this.user=user;
    }

    @Override
    public String toString() {
        return "UserMgr{" +
                "user=" + user +
                '}';
    }
}
