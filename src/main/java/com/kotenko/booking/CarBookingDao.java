package com.kotenko.booking;

import java.util.List;

public interface CarBookingDao {
    List<CarBooking> getCarBookings();

    void book(CarBooking carBooking);
}
