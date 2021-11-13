package com.sda.weather;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
    private Long id; // todo it is unnecessary, remove it
    private String cityName; // todo rename to 'city'
    private String region;
    private String country;
    private int longitude ;  // dł geograficzna // todo String type
    private int latitude ;  // szer. geograficzna // todo String type
}
