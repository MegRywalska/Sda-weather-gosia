package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
}
