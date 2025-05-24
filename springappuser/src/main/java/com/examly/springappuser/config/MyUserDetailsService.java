package com.examly.springappuser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examly.springappuser.model.User;
import com.examly.springappuser.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User user = userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found with email: "+email));
        return new UserPrinciple(user);
    }
}
