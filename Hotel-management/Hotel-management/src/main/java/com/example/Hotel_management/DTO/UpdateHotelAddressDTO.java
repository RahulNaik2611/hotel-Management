package com.example.Hotel_management.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateHotelAddressDTO {

    @NotBlank(message = "Address cannot be blank")
    @Size(max = 200, message = "Address cannot exceed 200 characters")
    private String address;

    @NotBlank(message = "City cannot be blank")
    @Size(max = 50, message = "City cannot exceed 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s\\-']+$",
            message = "City must contain only letters and basic punctuation")
    private String city;

    @Min(value = 1000, message = "Postal code must be 4-6 digits")
    @Max(value = 999999, message = "Postal code must be 4-6 digits")
    private int postalCode; // Primitive int (cannot be null)
}