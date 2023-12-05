package com.kotenko.cli.booking;

import com.kotenko.cli.car.Brand;
import com.kotenko.cli.car.Car;
import com.kotenko.cli.car.Engine;
import com.kotenko.cli.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CarBookingArrayDataAccessServiceTest {

    private CarBookingArrayDataAccessService service;

    @BeforeEach
    void setUp() {
        service = new CarBookingArrayDataAccessService();
    }

    @Test
    void getInitialSizeCarBookings() {
        //somehow it keeps state
        assertEquals(0, service.getCarBookings().size());
    }

    @Test
    void bookOneRandomCar() {
        CarBooking carBooking = new CarBooking(
                UUID.randomUUID(),
                new User(UUID.randomUUID(), "User"),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.MAZDA),
                LocalDateTime.now());
        service.book(carBooking);
        assertEquals(service.getCarBookings().get(0), carBooking);
    }
}