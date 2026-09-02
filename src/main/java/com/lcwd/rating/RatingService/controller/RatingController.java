package com.lcwd.rating.RatingService.controller;

import com.lcwd.rating.RatingService.entity.Rating;
import com.lcwd.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ms/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    //create
    @RequestMapping("/create")
    public ResponseEntity<?> create(@RequestBody Rating rating){
        return new ResponseEntity<>(ratingService.create(rating), HttpStatus.CREATED);

    }

    //get all
    @RequestMapping("/allratings")
    public ResponseEntity<List<Rating>> getRating(){
        return new ResponseEntity<List<Rating>>(ratingService.getRating(),HttpStatus.OK);
    }

    //get all by user id
    @RequestMapping("/users/{userid}")
    public ResponseEntity<List<Rating>> getRatingBYUserId(@PathVariable String userid){
       return new  ResponseEntity<List<Rating>>
               (ratingService.getRatingByUserId(userid),HttpStatus.OK);
    }

    //get all by hotel id
    @RequestMapping("/hotels/{hotelid}")
    public ResponseEntity<List<Rating>> getRatingBYHotelId(@PathVariable String hotelid){
        return new  ResponseEntity<List<Rating>>
                (ratingService.getRatingByHotelId(hotelid),HttpStatus.OK);
    }
}
