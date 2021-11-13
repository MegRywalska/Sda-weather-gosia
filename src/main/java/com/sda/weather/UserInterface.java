package com.sda.weather;

import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    public void open() {
        System.out.println();
        System.out.println("******************************************************************");
        System.out.println(" Hi !! I am your personal weather system. I will change your life.");
        System.out.println("******************************************************************");
    }

    public void runApplication() {

        while (true) {
            System.out.println("What you need today:");         // Menu
            System.out.println("1 My place ");
            System.out.println("2 Add location");
            System.out.println("3 The weather in my place ");
            System.out.println("4 Good bye");

            String choice =scanner.nextLine();

                switch (choice) {
                    case "1" :
                        myLocation();
                        break;
                    case "2":
                        addLocation();
                        break;
                    case "3":
                        weatherMyLocation();
                        break;
                    case "4" :
                        return;
                    default:
                        System.out.println("Illegal choice. Select again");
                        System.out.println();
                }
        }
    }

    private void addLocation() {
    }

    private void weatherMyLocation() {
    }

    private void myLocation() {
    }
}
