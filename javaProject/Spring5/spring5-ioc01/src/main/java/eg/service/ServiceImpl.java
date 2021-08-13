package eg.service;

import eg.dao.User;
import eg.dao.UserBImpl;



class ServiceImpl implements Service{
    User user;
    User set(User user){
        this.user=user;
        return user;
    }
    public void get() {
        user.get();
    }
}

class MyTest{
    public static void main(String[] args) {
        ServiceImpl service=new ServiceImpl();
        service.set(new UserBImpl());
        service.get();
    }
}