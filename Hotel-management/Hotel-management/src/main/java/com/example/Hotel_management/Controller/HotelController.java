package com.example.Hotel_management.Controller;


import com.example.Hotel_management.DTO.HotelDTO;
import com.example.Hotel_management.DTO.UpdateHotelAddressDTO;
import com.example.Hotel_management.Entity.Hotel;
import com.example.Hotel_management.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController
{
    @Autowired
  HotelService hotelService;

    @PostMapping("/createhotel")
   public ResponseEntity<Hotel> CreateHotel(@RequestBody HotelDTO hotelDTO)
   {
       return hotelService.saveHotel(hotelDTO);
   }

   @GetMapping("/getallhotels")
   public List<Hotel>getAllHotels()
   {
      return hotelService.getAllHotel();
   }


   @GetMapping("/gethotel/{id}")
   public ResponseEntity<Hotel> getHotelByid(@PathVariable Long id)
   {

      return hotelService.getHotelById(id);
   }

   @PutMapping("/updateHotel/{id}")
   public Hotel updateHotel(@RequestBody HotelDTO hotelDTO,@PathVariable Long id )
   {
       return  hotelService.updateHotel(hotelDTO,id)  ;
   }

   @DeleteMapping("/deleteHotel/{id}")
    public void deleteHotel(@PathVariable Long id)
   {
       hotelService.deleteHotelById(id);
   }

   @PutMapping("/updatehotelAddress/{id}")
   public  Hotel updateHotelAddress(@RequestBody UpdateHotelAddressDTO updateHotelAddressDTO, @PathVariable Long id )
   {
       return hotelService.updatehotelServices(updateHotelAddressDTO,id);
   }

}
