package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Users;

public interface UserService {
List<Users> getAllUsers();
void save(Users user);
Users getByIdUsers(Integer id);
void deleteViaId(int id);
}
