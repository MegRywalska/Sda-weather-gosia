package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class LocationService {

    private final LocationRepository locationRepository;
    private final ObjectMapper objectMapper;

    Location addNewLocation(String city, String region, String country, String longitude, String latitude) {
        int longitudeInt = Integer.parseInt(longitude); // todo catch a NumberFormatException and throw IllegalArgumentException
        int latitudeInt = Integer.parseInt(latitude);

//        if (region == null){
//            continue;
//        }
        if (city == null || city.isBlank() || country == null || country.isBlank()) {
            throw new IllegalArgumentException("Your location and country can't be empty!!");
        } else if (longitudeInt >= 180 || longitudeInt <= -180 || latitudeInt >= 90 || latitudeInt <= -90) {
            throw new IllegalArgumentException("You gave me the wrong coordinates :( ");
        }
//        else if (region == null){
//            continue;
//        }

        // todo check if region is not null and region is blank -> if yes -> region = null

        // LocationRepository locationRepository = new LocationRepositoryImplementation();
        return locationRepository.save(new Location(city, region, country, longitudeInt, latitudeInt));
    }
}
