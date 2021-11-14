package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherApplication {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        LocationRepositoryImplementation locationRepositoryImplementation = new LocationRepositoryImplementation();
        LocationService locationService = new LocationService(locationRepositoryImplementation,objectMapper);
        LocationController locationController = new LocationController(objectMapper,locationService);
        UserInterface userInterface = new UserInterface(locationController);

        userInterface.open();
        userInterface.runApplication();

    }
}
