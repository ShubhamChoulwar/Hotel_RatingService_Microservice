package com.micro.user.service.impl;

import com.micro.user.service.entities.User;
import com.micro.user.service.exceptions.ResourceNotFoundException;
import com.micro.user.service.repositories.UserRepository;
import com.micro.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        //generate unique user id
        Supplier<String> IdGenerator = () -> UUID.randomUUID().toString();
        String generatedId = IdGenerator.get();
        user.setId(generatedId);
    return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        //get single user by userId from database with the help of userRepository
        User user =  userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user id is not found on server!!!!!"));

        //fetch all ratings of user from rating service using API/Messaging queue
       //http://localhost:8082/ratings/users/13c28c02-f484-4bd4-9f95-d519bd6e6d50

        ArrayList ratingData =  restTemplate.getForEntity("http://localhost:8082/ratings/users/35353552-a5aa-467d-a11f-7e8c69704fa2", ArrayList.class).getBody();
        logger.info("rating data: " + String.valueOf(ratingData));
        user.setRatings(ratingData);
        return user;
    }
}
