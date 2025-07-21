package com.micro.hotel.service.HotelService.repositories;

import com.micro.hotel.service.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotelRepository extends JpaRepository<Hotel, String> {

    //you can have custom methods or queries
    /*@Query("select h from Hotel h where h.id = ?1")
    Hotel findByHotelId(String hotelId);*/

}
