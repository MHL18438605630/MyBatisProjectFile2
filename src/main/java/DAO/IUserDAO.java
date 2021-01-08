package DAO;

import domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDAO {
    @Select("select * from user")
    List<User> findAll();
}
