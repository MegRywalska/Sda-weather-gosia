package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class LocationServiceTest {

    private LocationService locationService;

    @BeforeEach
    void setUp(){
        ObjectMapper objectMapper = new ObjectMapper();
        LocationRepository locationRepository = new LocationRepositoryMock();
        locationService = new LocationService(locationRepository, objectMapper);
    }

    @Test
    void addNewLocation_whenEverythingIsCorrect_returnsNewLocation() {
        // when
        Location location = locationService.addNewLocation("London", "Middle", "UK", "10", "20");

        // then
        assertThat(location.getCity()).isEqualTo("London");
        assertThat(location.getRegion()).isEqualTo("Middle");
        assertThat(location.getCountry()).isEqualTo("UK");
        assertThat(location.getLongitude()).isEqualTo(10);
        assertThat(location.getLatitude()).isEqualTo(20);
    }

    // add test when region is empty -> it should return new location (OK)
    @Test
    void addNewLocation_whenRegionIsEmpty_returnNewLocation(){
        // when
        Location location = locationService.addNewLocation("London", "   ", "UK", "10", "20");

        //then
        assertThat(location.getRegion()).isEqualTo(null);

    }

    // add test when city is empty -> it should throw an exception
    @Test
    void addNewLocation_whenCityIsEmpty_throwIllegalArgumentException() throws IllegalArgumentException {
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("", "", "UK", "10", "20"));
        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    // add test when country is empty -> it should throw an exception
    @Test
    void addNewLocation_whenCountryIsEmpty_throwIllegalArgumentException() throws IllegalArgumentException {
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("London", "", "", "10", "20"));
        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    // add test when longitude is greater than a proper value -> it should throw an exception
    @Test
    void addNewLocation_whenLongitudeIsGreater_throwIllegalArgumentException(){
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("London", "", "UK", "181", "20"));

        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    // add test when longitude is lower than a proper value -> it should throw an exception
    @Test
    void addNewLocation_whenLongitudeIsLower_throwIllegalArgumentException(){
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("London", "", "UK", "-181", "20"));

        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    // add test when latitude is greater than a proper value -> it should throw an exception
    @Test
    void addNewLocation_whenLatitudeIsGreater_throwIllegalArgumentException(){
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("London", "", "UK", "20", "91"));

        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    // add test when latitude is lower than a proper value -> it should throw an exception
    @Test
    void addNewLocation_whenLatitudeIsLower_throwIllegalArgumentException(){
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("London", "", "UK", "20", "-91"));

        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    // add test when longitude has wrong format eg. "asd"
    @Test
    void addNewLocation_whenLongitudeHasWrongFormat_throwIllegalArgumentException(){
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("London", "", "UK", "abc", "20"));

        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    // add test when latitude has wrong format eg. "asd" -> throws new IllegalArgumentException
    @Test
    void addNewLocation_whenLatitudeHasWrongFormat_throwIllegalArgumentException(){
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("London", "", "UK", "50", "abc"));

        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
