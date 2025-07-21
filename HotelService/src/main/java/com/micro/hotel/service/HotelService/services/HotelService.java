package com.micro.hotel.service.HotelService.services;

import com.micro.hotel.service.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel create(Hotel hotel);

    //get all hotel
    List<Hotel> getAllListHotel();

    //get single hotel
    Hotel getSingleHotel(String id);
}

