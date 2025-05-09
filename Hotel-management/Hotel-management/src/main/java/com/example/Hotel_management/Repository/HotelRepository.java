package com.example.Hotel_management.Repository;

import com.example.Hotel_management.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel , Long>
{

}
