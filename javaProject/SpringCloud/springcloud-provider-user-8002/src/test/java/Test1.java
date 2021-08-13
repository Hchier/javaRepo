import demo.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import demo.utils.MybatisUtils;

import java.util.List;

public class Test1 {

    @Test
    public void selectByUsername() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.selectByUsername("Hchier");
        System.out.println(user.toString());
        sqlSession.close();
    }

}