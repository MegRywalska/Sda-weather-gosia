package com.sda.weather;

public interface LocationRepository {
    Location addNewLocation(Location location); // todo refactor to -> Location save(Location location)
}
