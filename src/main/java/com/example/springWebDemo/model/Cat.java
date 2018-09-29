package com.example.springWebDemo.model;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {

    @Override
    public String makeSound(){
        return "meow meow";
    }
}
