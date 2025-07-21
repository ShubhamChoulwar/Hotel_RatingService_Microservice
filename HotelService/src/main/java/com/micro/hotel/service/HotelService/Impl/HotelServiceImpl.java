package com.micro.hotel.service.HotelService.Impl;

import com.micro.hotel.service.HotelService.entities.Hotel;
import com.micro.hotel.service.HotelService.exceptions.ResourceNotFoundException;
import com.micro.hotel.service.HotelService.repositories.HotelRepository;
import com.micro.hotel.service.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        Supplier<String> IdGeneration = () -> UUID.randomUUID().toString();
        String generatedId  = IdGeneration.get();
        hotel.setId(generatedId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllListHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getSingleHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found on server!!"));
    }
}
