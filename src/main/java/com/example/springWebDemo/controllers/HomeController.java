package com.example.springWebDemo.controllers;

import com.example.springWebDemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private GreetingService greetingService;

    @RequestMapping("/")
    public String home(){
        return greetingService.greet();
    }
}
