package com.sda.weather;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Location {


    private String city;
    private String region;
    private String country;
    private String longitude;  // dł geograficzna
    private String latitude;  // szer. geograficzna
}
