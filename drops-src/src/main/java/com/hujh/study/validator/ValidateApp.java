package com.hujh.study.validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
@Configuration
public class ValidateApp {

    public static void main(String[] args) {
        SpringApplication.run(ValidateApp.class, args);
    }
    
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {  
      return new MethodValidationPostProcessor();
    }
    
    
    
    
    
}