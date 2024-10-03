package com.example.demo.controller;

import com.example.demo.model.Dummy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.repo.UserRepository;

//@RestController
//public class Dummycontroller {
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping
//    public ResponseEntity<String> addDummy(@RequestBody Dummy dummy) {
//        Dummy savedDummy = userRepository.save(dummy);
//        return ResponseEntity.ok("Dummy {"+savedDummy+"} was created successfully");
//
//    }
//    @GetMapping
//    public Iterable<Dummy> readAll(){
//        return userRepository.findAll();
//    }
//
//
//}
