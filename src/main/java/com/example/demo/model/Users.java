package com.example.demo.model;


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

    

 // Constructor
 public Users() {
    // This can be left empty or used to initialize default values if needed
    this.role = "patient";
}

 public Users(int id, String username, String email, String password, String role) {
    this.user_id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.role = (role == null || role.isEmpty()) ? "patient" : role;
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

}
    
