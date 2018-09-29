package com.example.springWebDemo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MeaningOfLife {

    final int lifeInt;
    final String lifeString;

    @Autowired
    public MeaningOfLife(@Value("#{@environment['life.int']?: 0}") int lifeInt, @Value("#{@environment['life.string']?:'sai'}") String lifeString) {
        this.lifeInt = lifeInt;
        this.lifeString = lifeString;
    }

    public int getLifeInt() {
        return lifeInt;
    }

    public String getLifeString() {
        return lifeString;
    }

}
