package com.example.demo.service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Users;
import com.example.demo.repo.UserRepository;

@Service
public class UserServiceImpl
    implements UserService {
   
    @Autowired private UserRepository userRepo;
 
    @Override public List<Users> getAllUsers()
    {
        return userRepo.findAll();
       
    }
     // Check if a user exists by email
     public boolean emailExists(String email) {
        return userRepo.findByEmail(email).isPresent();
    }

    // Check if a user exists by username
    public boolean usernameExists(String username) {
        return userRepo.findByUsername(username).isPresent();
    }
 
    @Override public void save(Users user)
    {    
        userRepo.save(user);
    }
 
    @Override public Users getByIdUsers(Integer id)
    {
        Optional<Users> optional = userRepo.findById(id);
        Users user = null;
        if (optional.isPresent())
            user = optional.get();
        else
            throw new RuntimeException(
                "Users not found for id : " + id);
        return user;
    }
 
    @Override public void deleteViaId(int id)
    {
        userRepo.deleteById(id);
    }
}
