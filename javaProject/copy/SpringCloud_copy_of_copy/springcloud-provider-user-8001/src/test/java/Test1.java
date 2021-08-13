


import demo.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import demo.utils.MybatisUtils;

public class Test1 {

    @Test
    public void selectByUsername() {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByName("Hchier");
        System.out.println(user.toString());
        sqlSession.close();
    }

}
