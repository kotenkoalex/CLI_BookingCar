package com.kotenko.cli.booking;

import java.util.Arrays;

public class CarBookingDao {
    private static CarBooking[] carBookings;
    private static int nextIndex = 0;

    static {
        carBookings = new CarBooking[5];
    }

    public CarBooking[] getCarBookings() {
        return carBookings;
    }

    public void book(CarBooking carBooking) {
        if (carBookings.length == nextIndex) {
            carBookings = Arrays.copyOf(carBookings, carBookings.length * 2);
        }
        carBookings[nextIndex++] = carBooking;
    }
}
