package com.example.springWebDemo.controllers;

import com.example.springWebDemo.model.AnimalIdentifier;
import com.example.springWebDemo.model.MeaningOfLife;
import com.example.springWebDemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private MeaningOfLife meaningOfLife;

    @Autowired
    private AnimalIdentifier animalIdentifier ;

    @RequestMapping("/")
    public String home(){
        return greetingService.greet();
    }

    @RequestMapping("/life")
    public int meaningOfLife(){
        return meaningOfLife.getLifeInt();
    }

    @RequestMapping("/sound")
    public String getAnimalSound(@RequestParam("animal") String animal){
        return animalIdentifier.getAnimalSound(animal);
    }
}
