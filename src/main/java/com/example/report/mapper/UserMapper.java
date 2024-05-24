package com.example.report.mapper;

import com.example.report.pojo.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user_table")
    List<UserEntity> findAllUser();

    @Select("select * from user_table where user_id=#{user_id}")
    UserEntity findUserById(@Param("user_id") int user_id);

    @Insert("insert into user_table(username, password) value(#{username}, #{password})")
    void createUser(@Param("username") String username, @Param("password") String password);
}
