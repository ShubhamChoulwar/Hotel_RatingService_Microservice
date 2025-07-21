package com.micro.rating.service.repositories;

import com.micro.rating.service.entites.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RatingRepository extends JpaRepository<Rating, String> {


    //custom queries method

    List<Rating> findByuserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
