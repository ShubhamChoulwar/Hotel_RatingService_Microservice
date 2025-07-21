package com.micro.rating.service.controllers;

import com.micro.rating.service.entites.Rating;
import com.micro.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //create rating
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        Rating createRating = ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRating);
    }

    //get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> ratings = ratingService.getratings();
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }

    //get ratings by userId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        List<Rating> ratingByuserId = ratingService.getAllByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(ratingByuserId);

    }

    //get ratings by HotelId
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId( @PathVariable String hotelId){
        List<Rating> ratingByHotelId = ratingService.getAllByHotelId(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(ratingByHotelId);
    }
}
