package com.example.report.controller;

import com.example.report.pojo.LoginReq;
import com.example.report.pojo.LoginRes;
import com.example.report.pojo.SignupReq;
import com.example.report.pojo.UserEntity;
import com.example.report.service.UserService;
import com.example.report.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
    
    @GetMapping("/all/users")
    public List<UserEntity> findAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/user/{user_id}")
    public UserEntity findUserById(@PathVariable("user_id") int user_id) {
        return userService.findUserById(user_id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReq loginReq) {
        int user_id = loginReq.getUser_id();
        String password = loginReq.getPassword();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user_id, password)
            );
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Username or password invalid", HttpStatus.BAD_REQUEST);
        }
        UserEntity user = findUserById(user_id);
        String token = jwtUtil.generate(user);
        LoginRes loginRes = new LoginRes(token, user.getUser_id(), user.getUsername());
        return new ResponseEntity<>(loginRes, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupReq signupReq) {
        String username = signupReq.getUsername();
        String password = signupReq.getPassword();
        userService.createUser(username, passwordEncoder.encode(password));
        return new ResponseEntity<>("Signup successfully!", HttpStatus.OK);
    }

}