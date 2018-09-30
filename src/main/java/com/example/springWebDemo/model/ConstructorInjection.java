package com.example.springWebDemo.model;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class ConstructorInjection {

    private final Dog dog;

    ConstructorInjection(Dog dog){
        this.dog = dog;
    }
}
