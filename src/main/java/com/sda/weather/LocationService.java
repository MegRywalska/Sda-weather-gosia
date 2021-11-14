package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
class LocationService {

    private final LocationRepository locationRepository;
    private final ObjectMapper objectMapper;

    Location addNewLocation(String city, String region, String country, String longitude, String latitude) {
        // todo Integer.parseInt()

        if (city == null || city.isBlank() || country == null || country.isBlank()) {
            throw new IllegalArgumentException("Your location and coutry can't be empty!! ");
        } else if (Integer.parseInt(longitude) >= 180 || Integer.parseInt(longitude) <= -180
                || Integer.parseInt(longitude) >= 90 || Integer.parseInt(longitude) <= -90) {
            throw new IllegalArgumentException("You gave me the wrong coordinates :( ");
        }

        // todo use LocationRepository
        return new Location("asd", "qwe", "zxc", 12, 12);
    }
}
