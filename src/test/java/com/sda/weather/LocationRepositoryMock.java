package com.sda.weather;

public class LocationRepositoryMock implements LocationRepository {

    @Override
    public Location addNewLocation(Location location) {
        return location;
    }
}
