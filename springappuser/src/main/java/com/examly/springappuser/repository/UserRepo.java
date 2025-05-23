package main.java.com.examly.springappuser.repository;

import java.util.Optional;

import main.java.com.examly.springappuser.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
  Optional<User> findByEmail(String email);
} 
