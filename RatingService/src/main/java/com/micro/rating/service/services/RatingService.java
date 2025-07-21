package com.micro.rating.service.services;

import com.micro.rating.service.entites.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);

    //get all ratings
    List<Rating> getratings();

    //get all by userId
    List<Rating> getAllByUserId(String userId);

    //get all by hotel
    List<Rating> getAllByHotelId(String hotelId);
}
