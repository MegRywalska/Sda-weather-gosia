package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class LocationService { // todo remove public modifier

    private final LocationRepository locationRepository;
    private final ObjectMapper objectMapper;

    // todo remove public modifier
    public Location addNewLocation(String city, String region, String country, String longitude, String latitude) {
        Pattern patternLatitude = Pattern.compile("[-90 -90]");
        Pattern patternLongitude = Pattern.compile("[-180-180]");

        // todo Integer.parseInt()

        Matcher matcherlongitude = patternLongitude.matcher(longitude);
        Matcher matcherlatitude = patternLatitude.matcher(latitude);


        if (city == null || city.isBlank() || country == null || country.isBlank()) {
            throw new IllegalArgumentException("Your location and coutry can't be empty!! ");
        } else if (!matcherlatitude.matches() || !matcherlongitude.matches()) {
            throw new IllegalArgumentException("You gave me the wrong coordinates :( ");
        }

        // todo use LocationRepository
        return null; // todo create new Location
    }
}
