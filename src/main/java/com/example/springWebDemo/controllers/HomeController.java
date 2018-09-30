package com.example.springWebDemo.controllers;

import com.example.springWebDemo.config.BasicConfiguration;
import com.example.springWebDemo.model.AnimalIdentifier;
import com.example.springWebDemo.model.ConstructorInjection;
import com.example.springWebDemo.model.MeaningOfLife;
import com.example.springWebDemo.services.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("")
public class HomeController {

    @Value("${welcome.message}")
    private String welcomeMsg;

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private MeaningOfLife meaningOfLife;

    @Autowired
    private AnimalIdentifier animalIdentifier;

    @Autowired
    private ConstructorInjection constructorInjection;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private BasicConfiguration basicConfiguration;

    @RequestMapping("")
    public String sendWelcomeMsg(){
        return welcomeMsg;
    }
    @RequestMapping("/greet")
    public String home() {
        return greetingService.greet();
    }

    @RequestMapping("/life")
    public int meaningOfLife() {
        return meaningOfLife.getLifeInt();
    }

    @GetMapping(value = "/sound", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getAnimalSound(@RequestParam("animal") String animal) {
        return animalIdentifier.getAnimalSound(animal);
    }

    @RequestMapping("/ci")
    public String checkConstructorDI() {
        log.info("Demo of constructor DI");
        return constructorInjection.getDog().makeSound();
    }

    @RequestMapping("/all")
    public String[] getAllAnimalNames() {
        return animalIdentifier.getAllAnimalSounds();
    }

    @RequestMapping("/beans")
    public Map<String, String[]> getAllBeans(@RequestParam(required = false) String name) {
        Map<String, String[]> result = new HashMap<>();
        String[] beans = Arrays.stream(applicationContext.getBeanDefinitionNames()).filter(beanName -> (name == null || name.length() == 0 || beanName.toLowerCase().contains(name.toLowerCase()))).toArray(String[]::new);
        result.put("beans", beans);
        return result;
    }

    @RequestMapping("/dynamic-configuration")
    public Map dynamicConfiguration() {
        // Not the best practice to use a map to store differnt types!
        Map map = new HashMap();
        map.put("message", basicConfiguration.getMessage());
        map.put("number", basicConfiguration.getNumber());
        map.put("key", basicConfiguration.isValue());
        return map;
    }
}
