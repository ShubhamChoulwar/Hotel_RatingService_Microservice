package com.micro.rating.service.impl;

import com.micro.rating.service.entites.Rating;
import com.micro.rating.service.repositories.RatingRepository;
import com.micro.rating.service.services.RatingService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private Logger logger;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        String GeneratedId = UUID.randomUUID().toString();
        rating.setRatingId(GeneratedId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getratings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllByUserId(String userId) {

        List<Rating> ratingWithHotelDetails = new ArrayList<Rating>();
        List<Rating> rating = ratingRepository.findByuserId(userId);
        for(Rating r : rating) {
            String hotelId = r.getHotelId();
            ArrayList hotelDetails = restTemplate.getForEntity("http://localhost:8081/hotels/singleHotel/" + hotelId, ArrayList.class).getBody();
            logger.info("hotelDetails: " + hotelDetails);//rating.set
            r.setHotelDetails(hotelDetails);
            ratingWithHotelDetails.add(r);
        }
        return ratingWithHotelDetails;
    }

    @Override
    public List<Rating> getAllByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
