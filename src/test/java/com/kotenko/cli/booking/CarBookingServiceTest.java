package com.kotenko.cli.booking;

import com.kotenko.booking.CarBooking;
import com.kotenko.booking.CarBookingArrayDataAccessService;
import com.kotenko.booking.CarBookingDao;
import com.kotenko.booking.CarBookingService;
import com.kotenko.car.*;
import com.kotenko.user.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CarBookingServiceTest {

    @Disabled
    @Test
    void bookRandomCar() throws Exception {
        CarBookingDao carBookingDao = new CarBookingArrayDataAccessService();
        CarDao carDao = new CarArrayDataAccessService();
        CarService carService = new CarService(carDao);

        CarBookingService service = new CarBookingService(carBookingDao, carService);

        CarBooking carBooking = new CarBooking(
                UUID.randomUUID(),
                new User(UUID.randomUUID(), "User"),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.MAZDA),
                LocalDateTime.now());

        service.bookCar(new User(UUID.randomUUID(), "User"),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.MAZDA));

        assertEquals(service.getCarBookings(), carBooking);
    }

    @Disabled
    @Test
    void getInitialSizeCarBookings() {
        CarBookingArrayDataAccessService service = new CarBookingArrayDataAccessService();
        assertEquals(0, service.getCarBookings().size());
    }

    @Disabled
    @Test
    void getAvailableCars() {
        //TODO
    }

    @Disabled
    @Test
    void getAllUserBookedCars() {
        //TODO
    }
}
