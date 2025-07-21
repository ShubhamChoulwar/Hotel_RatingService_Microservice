package com.micro.user.service.services;

import com.micro.user.service.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    //create
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user
    User getUser(String userId);

    //TODO update
    //TODO delete
}
