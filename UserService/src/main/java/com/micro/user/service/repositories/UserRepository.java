package com.micro.user.service.repositories;

import com.micro.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    //you can implement any custom method or  query here
}
