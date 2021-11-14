package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class LocationServiceTest {

    // todo prepare a setUp() method -> use @BeforeEach

    @Test
    void addNewLocation_whenEverythingIsCorrect_returnsNewLocation() {
        // given
        ObjectMapper objectMapper = new ObjectMapper();
        LocationRepository locationRepository = new LocationRepositoryMock();
        LocationService locationService = new LocationService(locationRepository, objectMapper);

        // when
        Location location = locationService.addNewLocation("London", "Middle", "UK", "10", "20");

        // then
        assertThat(location.getCity()).isEqualTo("London");
        assertThat(location.getRegion()).isEqualTo("Middle");
        assertThat(location.getCountry()).isEqualTo("UK");
        assertThat(location.getLongitude()).isEqualTo(10);
        assertThat(location.getLatitude()).isEqualTo(20);
    }

    // todo add test when region is empty -> it should return new location (OK)
    @Test
    void addNewLocation_whenRegionIsEmpty_returnNewLocation(){
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        LocationRepository locationRepository = new LocationRepositoryMock();
        LocationService locationService = new LocationService(locationRepository, objectMapper);

        // when
        Location location = locationService.addNewLocation("London", "   ", "UK", "10", "20");

        //then
        assertThat(location.getCity()).isEqualTo("London");
        assertThat(location.getRegion()).isEqualTo(null);
        assertThat(location.getCountry()).isEqualTo("UK");
        assertThat(location.getLongitude()).isEqualTo(10);
        assertThat(location.getLatitude()).isEqualTo(20);
    }

    // todo add test when city is empty -> it should throw an exception
    @Test
    void addNewLocation_whenCityIsEmpty_throwIllegalArgumentException() throws IllegalArgumentException {
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        LocationRepository locationRepository = new LocationRepositoryMock();
        LocationService locationService = new LocationService(locationRepository, objectMapper);

        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("", "", "UK", "10", "20"));
        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    // todo add test when country is empty -> it should throw an exception <-----------------------------------------------------

    // todo add test when longitude is greater than a proper value -> it should throw an exception

    @Test
    void addNewLocation_whenLongitudeIsGreater_throwIllegalArgumentException(){
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        LocationRepository locationRepository = new LocationRepositoryMock();
        LocationService locationService = new LocationService(locationRepository, objectMapper);

        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("London", "", "UK", "181", "20"));

        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    // todo add test when longitude is lower than a proper value -> it should throw an exception
    @Test
    void addNewLocation_whenLongitudeIsLower_throwIllegalArgumentException(){
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        LocationRepository locationRepository = new LocationRepositoryMock();
        LocationService locationService = new LocationService(locationRepository, objectMapper);

        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("London", "", "UK", "-181", "20"));

        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    // todo add test when latitude is greater than a proper value -> it should throw an exception
    @Test
    void addNewLocation_whenLatitudeIsGreater_throwIllegalArgumentException(){
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        LocationRepository locationRepository = new LocationRepositoryMock();
        LocationService locationService = new LocationService(locationRepository, objectMapper);

        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("London", "", "UK", "20", "91"));

        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    // todo add test when latitude is lower than a proper value -> it should throw an exception
    @Test
    void addNewLocation_whenLatitudeIsLower_throwIllegalArgumentException(){
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        LocationRepository locationRepository = new LocationRepositoryMock();
        LocationService locationService = new LocationService(locationRepository, objectMapper);

        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("London", "", "UK", "20", "-91"));

        //then
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    // todo add test when longitude has wrong format eg. "asd"
    // todo add test when latitude has wrong format eg. "asd" -> throws new IllegalArgumentException
}
