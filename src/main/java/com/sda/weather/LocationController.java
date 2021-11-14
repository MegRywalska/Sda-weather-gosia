package com.sda.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import java.util.Scanner;

@RequiredArgsConstructor
public class LocationController {

    private final ObjectMapper objectMapper;
    private final LocationService locationService;

    Scanner scanner = new Scanner(System.in); // todo make it private

    public String addNewLocation(String data) { // {"city": "London", "country": "UK" }
        try {
            LocationDTO locationDTO = objectMapper.readValue(data, LocationDTO.class);

            String cityName = locationDTO.getCity();
            String region = locationDTO.getRegion();
            String country = locationDTO.getCountry();
            String longitude = locationDTO.getLongitude();
            String latitude = locationDTO.getLatitude();

            Location location = locationService.addNewLocation(cityName, region, country, longitude, latitude);
            // todo use String.valueOf()
            LocationDTO addNewLocation = new LocationDTO(location.getCity(), location.getRegion(), location.getCountry(), location.getLongitude(), location.getLatitude());

            return objectMapper.writeValueAsString(addNewLocation);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // todo return a message with exception details as a JSON
        }
        return null; // todo remove it
    }
}
