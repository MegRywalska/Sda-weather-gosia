package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final ObjectMapper objectMapper;

    public Location addNewLocation(String city, String region, String country, String longitude, String latitude) {

        Pattern patternLatitude = Pattern.compile("[-90 -90]");
        Pattern patternLongitude = Pattern.compile("[-180-180]");

        Matcher matcherlongitude = patternLongitude.matcher(longitude);
        Matcher matcherlatitude = patternLatitude.matcher(latitude);


        if (city == null || city.isBlank() || country == null || country.isBlank()){
            throw new IllegalArgumentException("Your location and coutry can't be empty!! ");
        }else if (!matcherlatitude.matches() || !matcherlongitude.matches()){
            throw new IllegalArgumentException("You gave me the wrong coordinates :( ");
        }

        return null;
    }

}
