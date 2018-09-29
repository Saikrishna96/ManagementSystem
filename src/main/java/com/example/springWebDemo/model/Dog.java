package com.example.springWebDemo.model;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

    @Override
    public String makeSound(){
        return "bow bow!";
    }
}
