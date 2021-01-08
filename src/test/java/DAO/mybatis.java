package DAO;

import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class mybatis {
    /**
     * 入门案例
     * 不写DAO的实现类
     *
     * */
    public static void main(String[] args) throws Exception {
        //1：读取配置文件
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2:创建SqlSessionFactory 工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(inputStream);
        //3：使用工厂生产SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //4：使用SqlSession创建Dao接口的代理对象
        IUserDAO userDAO=sqlSession.getMapper(IUserDAO.class);
        //5：使用代理对象执行方法
        List<User> userList=userDAO.findAll();
        for(User user:userList)
        {
            System.out.println(user);
        }
        //6：释放资源
        sqlSession.close();
        inputStream.close();

    }
}
