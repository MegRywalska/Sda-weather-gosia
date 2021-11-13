package com.sda.weather;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class Location {


    private Long id;
    private String cityName;
    private String region;
    private String country;
    private int longitude ;  // dł geograficzna
    private int latitude ;  // szer. geograficzna

}
