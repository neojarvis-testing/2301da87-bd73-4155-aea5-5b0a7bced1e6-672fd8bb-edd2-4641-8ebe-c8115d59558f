package main.java.com.examly.springappuser.service;

import java.net.Authenticator;

import main.java.com.examly.springappuser.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthernticationManager authernticationManager;
    
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
