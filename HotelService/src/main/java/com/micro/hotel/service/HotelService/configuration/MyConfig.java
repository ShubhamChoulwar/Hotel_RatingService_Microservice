package com.micro.hotel.service.HotelService.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class MyConfig {

    @Bean
    public Logger logger() {
        return  LoggerFactory.getLogger(MyConfig.class);
    }
}
