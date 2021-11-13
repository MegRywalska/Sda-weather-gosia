package com.sda.weather;

import lombok.RequiredArgsConstructor;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Scanner;

@RequiredArgsConstructor
public class LocationController {

    private final ObjectMapper ;

    Scanner scanner = new Scanner(System.in);

    public String addNewLocation() {


        System.out.println(" Your city : ");
        String cityName = scanner.nextLine();

        System.out.println(" Which region is your city located ? : ");
        String region = scanner.nextLine();

        System.out.println(" Which country is your city located ? : ");
        String country = scanner.nextLine();

        System.out.println("Give me the coordinates :) Longitude :  ");
        String longitude = scanner.nextLine();

        System.out.println(" Latitude :  ");
        String latitude  = scanner.nextLine();

        LocationDTO location = obje;

        return "LocationDTO{" +
                "cityName='" + cityName + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
