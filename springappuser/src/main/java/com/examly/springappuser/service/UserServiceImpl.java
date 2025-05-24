package com.examly.springappuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.examly.springappuser.config.JwtUtils;
import com.examly.springappuser.model.LoginDTO;
import com.examly.springappuser.model.User;
import com.examly.springappuser.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authernticationManager;
    
    @Override
    public User createUser(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public String loginUser(LoginDTO loginDto){
        Authentication auth = authernticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            loginDto.getEmail(),
            loginDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(auth);
        return jwtUtils.generateToken(auth);
    }
}
