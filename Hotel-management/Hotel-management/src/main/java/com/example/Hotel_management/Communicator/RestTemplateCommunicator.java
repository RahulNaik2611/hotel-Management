package com.example.Hotel_management.Communicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateCommunicator {

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateCommunicator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Float getActualHotelRating(Long hotelId) {
        String url = "http://localhost:9090/rating/getratingbyhotelid/" + hotelId;

        try {
            ResponseEntity<Float> hotelRating = restTemplate.getForEntity(url, Float.class);
            return hotelRating.getBody();
        } catch (RestClientException e) {
            // You can log this exception if needed
            System.err.println("Failed to fetch rating for hotelId: " + hotelId);
            return 0.0f; // fallback rating or consider throwing custom exception
        }
    }
}
