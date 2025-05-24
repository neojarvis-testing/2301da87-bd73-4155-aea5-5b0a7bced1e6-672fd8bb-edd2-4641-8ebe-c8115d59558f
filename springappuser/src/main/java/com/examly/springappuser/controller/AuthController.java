package com.examly.springappuser.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springappuser.model.LoginDTO;
import com.examly.springappuser.model.User;
import com.examly.springappuser.service.UserService;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO loginDto){
        String token = userService.loginUser(loginDto);
        Map<String, String> response = new HashMap<>();
        response.put("token",token);
        return ResponseEntity.ok(response);
    }
}
