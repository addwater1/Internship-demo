package com.example.report.service;

import com.example.report.mapper.UserMapper;
import com.example.report.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserEntity> findAllUser() {
        return userMapper.findAllUser();
    }

    public UserEntity findUserById(int user_id) {
        return userMapper.findUserById(user_id);
    }

    public void createUser(String username, String password) {
        userMapper.createUser(username, password);
    }
}
