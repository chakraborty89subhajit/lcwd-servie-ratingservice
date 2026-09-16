package com.lcwd.rating.RatingService.serviceImpl;

import com.lcwd.rating.RatingService.Repo.RatingRepo;
import com.lcwd.rating.RatingService.entity.Rating;
import com.lcwd.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;
    @Override
    public Rating create(Rating rating) {
        String ratingId= UUID.randomUUID().toString();
        rating.setId(ratingId);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRating() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }

    @Override
    public Rating updateRating(String ratingId, Rating rating) throws Exception{

        Rating existingRating = ratingRepo.findById(ratingId)
                .orElseThrow(() -> new Exception("Rating with given ID not found on server !! : " + ratingId));

        // Explicitly re-confirm the primary key ID on the entity
        existingRating.setId(ratingId);

        existingRating.setRating(rating.getRating());
        existingRating.setFeedback(rating.getFeedback());

        // Avoid setting empty strings to foreign keys if they are optional
        if (rating.getUserId() != null && !rating.getUserId().isEmpty()) {
            existingRating.setUserId(rating.getUserId());
        }
        if (rating.getHotelId() != null && !rating.getHotelId().isEmpty()) {
            existingRating.setHotelId(rating.getHotelId());
        }

        return ratingRepo.save(existingRating);
    }
}
