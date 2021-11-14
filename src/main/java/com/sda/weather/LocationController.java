package com.sda.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.Scanner;

@RequiredArgsConstructor
public class LocationController {

    private final ObjectMapper objectMapper;
    private final LocationService locationService;

    private Scanner scanner = new Scanner(System.in); // todo remove it

    public String addNewLocation(String data) { // {"city": "London", "country": "UK" }
        try {
            LocationDTO locationDTO = objectMapper.readValue(data, LocationDTO.class);

            String cityName = locationDTO.getCity();
            String region = locationDTO.getRegion();
            String country = locationDTO.getCountry();
            String longitude = locationDTO.getLongitude();
            String latitude = locationDTO.getLatitude();

            Location location = locationService.addNewLocation(cityName, region, country, longitude, latitude);
            LocationDTO addNewLocation = new LocationDTO(location.getCity(), location.getRegion(), location.getCountry(),
                    String.valueOf(location.getLongitude()), String.valueOf(location.getLatitude()));
            // z racji że w location są int to używamy String.valueOf
            return objectMapper.writeValueAsString(addNewLocation);
        } catch (JsonProcessingException e) {
            return String.format("{\"massager\": \"%s\"}", e.getMessage());
        }
    }
}
