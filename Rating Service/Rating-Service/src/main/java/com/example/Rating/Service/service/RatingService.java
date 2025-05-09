package com.example.Rating.Service.service;

import com.example.Rating.Service.Entity.Rating;
import com.example.Rating.Service.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating getRatingByHotelId(Long hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
