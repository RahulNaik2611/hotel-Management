package com.example.Rating.Service.Repository;

import com.example.Rating.Service.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
   Rating findByHotelId(Long hotelId); // Corrected method name
}
