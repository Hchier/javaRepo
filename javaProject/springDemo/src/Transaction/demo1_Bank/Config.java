package Transaction.demo1_Bank;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"Transaction.demo1_Bank"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
//开启事务
@EnableTransactionManagement
public class Config {
    //创建数据库连接池
    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/bank?&amp");
        //  url不一样？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
        dataSource.setUsername("root");
        dataSource.setPassword("pyh903903");
        return dataSource;
    }
    @Bean
    public JdbcTemplate getJdbcTemplate(){

        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource());
        return jdbcTemplate;
    }
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(){
        DataSourceTransactionManager transactionManager =new DataSourceTransactionManager();
        transactionManager.setDataSource(druidDataSource());
        return  transactionManager;
    }

}
