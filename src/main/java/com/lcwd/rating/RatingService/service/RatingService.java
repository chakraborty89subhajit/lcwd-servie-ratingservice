package com.lcwd.rating.RatingService.service;

import com.lcwd.rating.RatingService.entity.Rating;

import java.util.List;

public interface RatingService {
    //create
    public Rating create(Rating rating);
    //getAllRating
    public List<Rating> getRating();
    //get all by user id
    public List<Rating> getRatingByUserId(String userId);
    //get All by hotel Id
    public List<Rating> getRatingByHotelId(String hotelId);
}
