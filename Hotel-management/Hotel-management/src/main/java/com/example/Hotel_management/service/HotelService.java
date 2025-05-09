package com.example.Hotel_management.service;

import com.example.Hotel_management.Communicator.RestTemplateCommunicator;
import com.example.Hotel_management.DTO.HotelDTO;
import com.example.Hotel_management.DTO.UpdateHotelAddressDTO;
import com.example.Hotel_management.Entity.Hotel;
import com.example.Hotel_management.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    @Autowired
    RestTemplateCommunicator restTemplateCommunicator;

    public ResponseEntity<Hotel> saveHotel(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDTO.getName());
        hotel.setAddress(hotelDTO.getAddress());
        hotel.setCity(hotelDTO.getCity());
        hotel.setPostalCode(hotelDTO.getPostalCode());
        hotel.setRating(hotelDTO.getRating());
        hotel.setAvailable(hotelDTO.getIsAvailable());

        hotelRepository.save(hotel);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    public ResponseEntity<Hotel> getHotelById(Long id) {
        Optional<Hotel> hotelBox = hotelRepository.findById(id);

        if (hotelBox.isPresent()) {
            Hotel hotel = hotelBox.get();
            Float hotelActualRating = restTemplateCommunicator.getActualHotelRating(id);
            hotel.setRating(hotelActualRating);
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }



    // Internal method to get Hotel object (null if not found)
    private Hotel findHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public Hotel updateHotel(HotelDTO hotelDTO, Long id) {
        Hotel hotel = findHotelById(id);
        if (hotel != null) {
            hotel.setName(hotelDTO.getName());
            hotel.setAddress(hotelDTO.getAddress());
            hotel.setCity(hotelDTO.getCity());
            hotel.setPostalCode(hotelDTO.getPostalCode());
            hotel.setRating(hotelDTO.getRating());
            hotel.setAvailable(hotelDTO.getIsAvailable());
            return hotelRepository.save(hotel);
        }
        return null;
    }

    public void deleteHotelById(Long id) {
        Hotel hotel = findHotelById(id);
        if (hotel != null) {
            hotelRepository.deleteById(id);
        }
    }

    public Hotel updatehotelServices(UpdateHotelAddressDTO updateHotelAddressDTO, Long id) {
        Hotel hotel = findHotelById(id);
        if (hotel != null) {
            hotel.setAddress(updateHotelAddressDTO.getAddress());
            hotel.setCity(updateHotelAddressDTO.getCity());
            hotel.setPostalCode(updateHotelAddressDTO.getPostalCode());
            return hotelRepository.save(hotel);
        }
        return null;
    }
}
