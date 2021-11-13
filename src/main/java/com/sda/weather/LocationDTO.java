package com.sda.weather;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {

    private String cityName;
    private String region;
    private String country;
    private int longitude ;  // dł geograficzna
    private int latitude ;  // szer. geograficzna

}
