package dev.dolly.ProductService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate(){
         return new RestTemplate();
    }
}

//Configuration -> Spring executes this class during initial build
//and calls all the method of this class

//whatever each method returns.
//it gets injected in the IOC containers as a bean(Object)

//this allows us to use those objects as dependencies at multiple places
