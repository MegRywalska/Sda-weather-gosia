package com.sda.weather;

import lombok.*;
import java.util.Scanner;


@RequiredArgsConstructor  // tworzy konstruktor do pól finalnych
public class UserInterface {

    private final LocationController locationController;

    Scanner scanner = new Scanner(System.in);

    public void open() {
        System.out.println();
        System.out.println("******************************************************************");
        System.out.println(" Hi !! I am your personal weather system. I will change your life.");
        System.out.println("******************************************************************");
    }

    public void runApplication() {

        while (true) {
            System.out.println("What do you need today:");         // Menu
            System.out.println("1 My place ");
            System.out.println("2 Add location");
            System.out.println("3 The weather in my place ");
            System.out.println("4 Good bye");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    myLocation();
                    break;
                case "2":
                   locationController.addNewLocation(addNewLocation());
                    break;
                case "3":
                    weatherMyLocation();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Illegal choice. Select again");
                    System.out.println();
            }
        }
    }

    public String addNewLocation() {
        System.out.println(" Your city : ");
        String city = scanner.nextLine();

        System.out.println(" Which region is your city located ? : ");
        String region = scanner.nextLine();

        System.out.println(" Which country is your city located ? : ");
        String country = scanner.nextLine();

        System.out.println("Give me the coordinates :) Longitude :  ");
        String longitude = scanner.nextLine();

        System.out.println(" Latitude :  ");
        String latitude = scanner.nextLine();

        return String.format("{\"city\": \"%s\", \"region\": \"%s\", " +
                "\"country\": \"%s\",\"longitude\": " +
                "\"%s\",\"latitude\": \"%s\",}", city, region, country, longitude, latitude);
    }

    private void weatherMyLocation() {
    }

    private void myLocation() {
    }
}
