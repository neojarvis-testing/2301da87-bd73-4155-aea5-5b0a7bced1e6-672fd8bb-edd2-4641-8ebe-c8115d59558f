package main.java.com.examly.springappuser.service;

import main.java.com.examly.springappuser.model.LoginDTO;

public interface UserService {
    User createUser(User user);
    String loginUser(LoginDTO loginDTO);
}
