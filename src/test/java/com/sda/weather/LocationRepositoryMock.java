package com.sda.weather;

public class LocationRepositoryMock implements LocationRepository {

    @Override
    public Location save(Location location) {
        return location;
    }
}
