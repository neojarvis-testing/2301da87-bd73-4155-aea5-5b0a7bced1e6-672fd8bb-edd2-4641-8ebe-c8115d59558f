package com.examly.springappuser.service;

import com.examly.springappuser.model.LoginDTO;
import com.examly.springappuser.model.User;

public interface UserService {
    User createUser(User user);
    String loginUser(LoginDTO loginDTO);
}
