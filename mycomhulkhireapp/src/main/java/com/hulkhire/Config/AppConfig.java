package com.hulkhire.Controller;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

@Configuration
public class AppConfig {

    @Bean
    public Random getRandom() {
        return new Random();
    }
    
    @Bean
     Gson getGson() {
    	return new Gson();
    }
}

