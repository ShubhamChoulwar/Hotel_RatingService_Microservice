package com.micro.hotel.service.HotelService.controller;

import com.micro.hotel.service.HotelService.entities.Hotel;
import com.micro.hotel.service.HotelService.services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @Autowired
    private Logger logger = LoggerFactory.getLogger(HotelController.class);

    //create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    //get single hotel
    /*@GetMapping("/singleHotel/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId){
        logger.info("hotelId: " + hotelId + " fetched successfully");
        Hotel hotel2 = hotelService.getSingleHotel(hotelId);

        return ResponseEntity.status(HttpStatus.OK).body(hotel2);
    }*/

    @GetMapping("/singleHotel/{hotelId}")
    public Hotel getSingleHotel(@PathVariable String hotelId){
        logger.info("hotelId: " + hotelId + " fetched successfully");
        Hotel hotel2 = hotelService.getSingleHotel(hotelId);

        return hotel2;
    }

    //get all hotel
    @GetMapping("/allHotels")
    public ResponseEntity<List<Hotel>> getAllHotel(){
        List<Hotel> hotel3 = hotelService.getAllListHotel();
        logger.info("fetched successfully all");
        return ResponseEntity.status(HttpStatus.OK).body(hotel3);
    }
}
