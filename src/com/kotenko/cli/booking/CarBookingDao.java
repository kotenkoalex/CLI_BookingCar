package com.kotenko.cli.booking;

public class CarBookingDao {
    private final static CarBooking[] carBookings;

    static {
        carBookings = new CarBooking[5];
    }

    public CarBooking[] getCarBookings() {
        return carBookings;
    }

    public void book(CarBooking carBooking) {
        //TODO
    }
}
