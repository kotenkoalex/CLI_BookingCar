package main.java.com.kotenko.cli.booking;

import java.util.Arrays;

public class CarBookingArrayDataAccessService implements CarBookingDao{
    private static CarBooking[] carBookings;
    private static int nextIndex = 0;

    static {
        carBookings = new CarBooking[5];
    }

    @Override
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
