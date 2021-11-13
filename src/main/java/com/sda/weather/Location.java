package com.sda.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String name;
    private String region;
    private String country;
    private int []  longitude = {0, 0};  // dł geograficzna
    private int []  latitude = {0, 0};   // szer. geograficzna
}
