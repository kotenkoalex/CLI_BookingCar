package com.kotenko.cli.booking;

import java.util.ArrayList;
import java.util.List;

public class CarBookingDao {
    private final static List<CarBooking> carBookings;

    static {
        carBookings = new ArrayList<>();
    }

    public List<CarBooking> getCarBookings() {
        return carBookings;
    }

    public void book(CarBooking carBooking) {
        carBookings.add(carBooking);
    }
}
