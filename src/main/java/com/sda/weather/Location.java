package com.sda.weather;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    // todo Long id; when you use hibernate
    private String city;
    private String region;
    private String country;
    private String longitude;  // dł geograficzna // todo it should be int
    private String latitude;  // szer. geograficzna // todo it should be int
}
