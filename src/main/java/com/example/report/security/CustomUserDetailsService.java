package com.example.report.security;

import com.example.report.pojo.UserEntity;
import com.example.report.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String user_id) {
        UserEntity user = userService.findUserById(Integer.parseInt(user_id));
        if (user == null) throw new UsernameNotFoundException("User not found");
        return User.withUsername(String.valueOf(user.getUser_id()))
                .password(user.getPassword())
                .build();
    }
}
