package com.examly.springappfeedback.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.examly.springappfeedback.dto.UserDTO;

@FeignClient(name = "springappuser")
public interface UserClient {
    @GetMapping("/api/user/{id}")
    UserDTO getUserById(@PathVariable("id") Long id);
} 
