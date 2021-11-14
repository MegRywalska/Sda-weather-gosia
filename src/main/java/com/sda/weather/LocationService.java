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
        int longitudeInt = Integer.parseInt(longitude);
        int latitudeInt = Integer.parseInt(latitude);

        if (city == null || city.isBlank() || country == null || country.isBlank()) {
            throw new IllegalArgumentException("Your location and coutry can't be empty!! ");
        } else if ( longitudeInt>= 180 || longitudeInt<= -180
                || latitudeInt>= 90 || latitudeInt <= -90) {
            throw new IllegalArgumentException("You gave me the wrong coordinates :( ");
        }

        // todo use LocationRepository
        return new Location(city, region, country, longitudeInt, latitudeInt);
    }
}
