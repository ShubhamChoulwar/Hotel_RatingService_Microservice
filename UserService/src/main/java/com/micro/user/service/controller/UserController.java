package com.micro.user.service.controller;


import com.micro.user.service.entities.User;
import com.micro.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    //create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser( @PathVariable String userId){
        User user2 = userService.getUser(userId);
        return ResponseEntity.ok(user2);
    }

    //get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> user3 = userService.getAllUser();
        return ResponseEntity.ok(user3);
    }

}
