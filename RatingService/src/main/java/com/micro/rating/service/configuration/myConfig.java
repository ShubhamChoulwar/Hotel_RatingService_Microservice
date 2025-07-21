package com.micro.rating.service.configuration;

import com.micro.hotel.service.HotelService.configuration.MyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class myConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Logger logger() {
        return  LoggerFactory.getLogger(myConfig.class);

    }


}
