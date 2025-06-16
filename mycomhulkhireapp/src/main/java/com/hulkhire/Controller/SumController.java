package com.hulkhire.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hulkhire.Service.CalculatorService;
import com.hulkhire.dto.AddRequest;
import com.hulkhire.dto.AddResponse;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/sum")
public class SumController {

    private static final Logger log = LoggerFactory.getLogger(SumController.class);

    private final CalculatorService calculatorService;
    private final String mytestkey;

    @Autowired
    public SumController(CalculatorService calculatorService, 
                         @Value("${mytestkey}") String mytestkey) {
        this.calculatorService = calculatorService;
        this.mytestkey = mytestkey;
        log.info("Loaded mytestkey from properties: {}", mytestkey);
    }
    @PostConstruct
    public void init() {
    	log.info("CalculatorService been created,myTest:{}",mytestkey);
    }

    @PostMapping
    public ResponseEntity<AddResponse> add(@RequestBody AddRequest request) {
        int result = calculatorService.add(request);
        log.info("Processing add request with mytestkey: {}", mytestkey); // log usage
        return ResponseEntity.ok(new AddResponse(result));
    }
}


