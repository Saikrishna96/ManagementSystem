package com.example.springWebDemo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AnimalIdentifier {

    private Dog dog;
    private Cat cat;

    private Animal[] animals;

    @Autowired
    public void setAnimals(Animal[] animals){
        this.animals = animals;
    }

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

    public String[] getAllAnimalSounds(){
        return Arrays.stream(animals).map(Animal::makeSound).toArray(String[]::new);
    }
}
