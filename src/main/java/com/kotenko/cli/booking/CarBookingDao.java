package com.kotenko.cli.booking;

import java.util.List;

public interface CarBookingDao {
    List<CarBooking> getCarBookings();

    void book(CarBooking carBooking);
}
