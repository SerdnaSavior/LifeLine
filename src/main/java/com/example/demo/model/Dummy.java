package com.example.demo.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class Dummy {
    @Id
    private int user_id;
    private String username;
    private String email;
    private String password;

    

 // Constructor
 public Dummy(int id, String username, String email, String password) {
    this.user_id = id;
    this.username = username;
    this.email = email;
    this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dummy dummy = (Dummy) o;
        return user_id == dummy.user_id && Objects.equals(username, dummy.username) && Objects.equals(email, dummy.email) && Objects.equals(password, dummy.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, email, password);
    }

    // ToString method to print the user info
@Override
public String toString() {
    return "User{" +
            "id=" + user_id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            '}';
}
}
