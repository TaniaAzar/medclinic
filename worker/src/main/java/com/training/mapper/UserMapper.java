package com.training.mapper;

import com.training.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select id, email, login, password from users")
    List<User> findAllUsers();

    @Select("select id, email, login, password from users WHERE id=#{id}")
    User getUserById(int id);
}
