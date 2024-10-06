package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.example.demo.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    // Check if a user exists by email
    Optional<Users> findByEmail(String email);

    // Check if a user exists by username
    Optional<Users> findByUsername(String username);
}
