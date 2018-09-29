package com.example.springWebDemo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AnimalIdentifier {

    private Dog dog;
    private Cat cat;

    @Autowired
    @Qualifier("dog")
    public void setDog(Dog dog){
        this.dog = dog;
    }

    @Autowired
    @Qualifier("cat")
    public void setCat(Cat cat){
        this.cat = cat;
    }

    public String getAnimalSound(String animal){
        switch (animal){
            case "dog":
                return dog.makeSound();
            case "cat":
                return cat.makeSound();
            default:
                return "UNKNOWN";
        }
    }
}
