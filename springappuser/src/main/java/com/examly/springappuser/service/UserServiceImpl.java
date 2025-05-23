package main.java.com.examly.springappuser.service;

import main.java.com.examly.springappuser.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthernticationManager authernticationManager;
    
}
