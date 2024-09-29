package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DummyController{
    @RequestMapping("/hello")
    String displayDefaultMessage() {
        return "Hello World!" ;
    }
    
}
