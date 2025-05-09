package com.example.Rating.Service.Controller;

import com.example.Rating.Service.Entity.Rating;
import com.example.Rating.Service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/addrating")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        Rating ratingNew = ratingService.addRating(rating);
        return new ResponseEntity<>(ratingNew, HttpStatus.CREATED);
    }

    @GetMapping("/getratingbyhotelid/{hotelId}")
    public ResponseEntity<Float> getRatingByHotelId(@PathVariable Long hotelId) {
        Rating rating = ratingService.getRatingByHotelId(hotelId);
        return new ResponseEntity<>(rating.getHotelActualRating(), HttpStatus.OK);
    }
}
