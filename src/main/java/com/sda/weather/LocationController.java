package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class LocationController {

    private final ObjectMapper objectMapper;
    private final LocationService locationService;

    Scanner scanner = new Scanner(System.in);

    public String addNewLocation(String data) { // {"city": "London", "country": "UK" }
        // todo use try-catch
        LocationDTO locationDTO = objectMapper.readValue(data, LocationDTO.class);
        String cityName = locationDTO.getCityName();
        String region = locationDTO.getRegion();
        String country = locationDTO.getCountry();
        int longitude = locationDTO.getLongitude(); // todo String type
        int latitude = locationDTO.getLatitude(); // todo String type

        // todo create a addNewLocation method
        Location location = locationService.addNewLocation(cityName, region, country, longitude, latitude);\
        // todo Long, String, String, String, int, int (String, String, String, String, String)
        LocationDTO addNewLocation = new LocationDTO(location.getId(), location.getCityName(), location.getRegion(), location.getLongitude(), location.getLatitude())

        // todo get a JSON   -> String addNewLocation(String data)
        // todo deserialize a JSON to eg. LocationDTO by using new ObjectMapper()

        // todo use try-catch
        return objectMapper.writeValueAsString(addNewLocation);
    }
}
