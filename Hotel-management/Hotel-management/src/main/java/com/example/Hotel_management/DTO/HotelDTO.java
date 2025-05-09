package com.example.Hotel_management.DTO;
// package names should be lowercase

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class HotelDTO {

    @NotNull(message = "Availability status is required")
    private Boolean isAvailable;  // Changed to Boolean wrapper class

    @NotBlank(message = "Hotel name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2-100 characters")
    private String name;  // Changed to lowercase first letter (Java convention)

    @NotBlank(message = "Address cannot be blank")
    @Size(max = 200, message = "Address cannot exceed 200 characters")
    private String address;

    @NotBlank(message = "City cannot be blank")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "City must contain only letters")
    private String city;

    @NotNull(message = "Postal code cannot be null")
    @Positive(message = "Postal code must be positive")
    @Min(value = 1000, message = "Postal code too short")
    @Max(value = 999999, message = "Postal code too long")
    private Integer postalCode;  // Changed to Integer wrapper class

    @NotNull(message = "Rating cannot be null")
    @DecimalMin(value = "0.0", message = "Rating cannot be negative")
    @DecimalMax(value = "5.0", message = "Rating cannot exceed 5.0")
    private Float rating;  // Changed to Float wrapper class
}