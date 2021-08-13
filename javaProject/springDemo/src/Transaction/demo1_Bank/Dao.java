package Transaction.demo1_Bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component(value = "dao")
public class Dao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int subMoney(String username, int money) {
        String sql_select = "select money from bank where username=?";

        String sql_sub = "update bank set money=money-? where username=?";
        jdbcTemplate.update(sql_sub, money, username);
        return 0;
    }

    public int addMoney(String username, int money) {
        String sql_add = "update bank set money=money+? where username=?";
        jdbcTemplate.update(sql_add, money, username);
        return 0;
    }


}
