package com.micro.rating.service.entites;

import com.micro.hotel.service.HotelService.entities.Hotel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    private String ratingId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "HOTEL_ID")
    private String hotelId;

    @Column(name = "RATING")
    private int rating;

    @Column(name = "FEEDBACK")
    private String feedback;



    @Transient       //this annotation is used to inform JPA to not consider for DB saving
    private List<Hotel> hotelDetails;

    public List<Hotel> getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(List<Hotel> hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
