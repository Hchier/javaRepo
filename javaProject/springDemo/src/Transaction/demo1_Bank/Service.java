package Transaction.demo1_Bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "service1")
//添加事务注解
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, timeout = -1, readOnly = false)
class Service1 {
    @Autowired
    Dao dao;

    public void transferMoney(String username1, String username2, int money) {
        //  1  编程式
//        try {
//            dao.subMoney(username1, money);
//            int i = 10 / 0;
//            dao.addMoney(username2, money);
//        }catch(Exception e){
//            //出现异常后，事务回滚到初始状态
//        }

        //2 声明式
        dao.subMoney(username1, money);
       // int i = 1 / 0;
        dao.addMoney(username2, money);
    }
}

//事务：逻辑上的一组操作，其各个子功能要么都执行，要么都不执行
//1 编程式 2 声明式
//二：声明式
//1，配置事务管理器
//2，在spring配置文件中，开启事务注解
//3，在service类上面添加事务注解
class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                //= new ClassPathXmlApplicationContext("Transaction/demo1_Bank/bean.xml");
                = new AnnotationConfigApplicationContext("Transaction.demo1_Bank");
        Service1 service = applicationContext.getBean("service1", Service1.class);
        service.transferMoney("Alice", "Bob", 100);
    }
}