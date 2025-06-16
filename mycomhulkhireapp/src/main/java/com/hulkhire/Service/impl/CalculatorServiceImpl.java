package com.hulkhire.Service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.hulkhire.Pojo.Addreq;

@Service
public class CalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    private final Random random;
    private final Gson gson;

    // Constructor injection
    public CalculatorService() {
        this.random = new Random();  // initialize internally unless needed for testing/mocking
        this.gson = new Gson();      // create Gson instance
    }

    public int addnumbers(Addreq addreq) {
        logger.info("Adding numbers: num1={}, num2={}", addreq.getNum1(), addreq.getNum1());

        int sum = addreq.getNum1() + addreq.getNum1();
        int randInt = random.nextInt(100);  // Random number between 0-99
        logger.info("Random number generated: {}", randInt);

        String json = gson.toJson(addreq);
        logger.info("Addreq object in JSON format: {}", json);

        logger.info("Final sum calculated: {}", sum);
        return sum;
    }
}
