package com.example.springWebDemo.services;

import org.springframework.stereotype.Service;

@Service
public class EnglishGreetingService implements GreetingService {

    @Override
    public String greet(){
        return "hello world";
    }
}
