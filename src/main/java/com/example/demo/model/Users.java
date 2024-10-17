package com.example.demo.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity()
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int user_id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String first_name;
    private String last_name;
    private LocalDate dob;

    

 // Constructor
 public Users() {
    // This can be left empty or used to initialize default values if needed
    
}

 public Users(int id, String username, String email, String password, String role,String first_name,String last_name,
LocalDate dob) {
    this.user_id = id;
    this.username = username;
    this.email = email;
    this.password = password;    
    this.first_name =first_name;
    this.last_name=last_name;
    this.dob=dob;
}

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
    
