package com.kotenko.cli.booking;

public class CarBookingDao {
    private final static CarBooking[] carBookings;

    static {
        carBookings = new CarBooking[5];
//test data
//        carBookings[0] = new CarBooking(
//                UUID.fromString("114b9220-a47a-45a7-a33b-7182ee0dc30e"),
//                new User(UUID.fromString("114b9220-a47a-45a7-a33b-7182ee0dc30e"), "name"),
//                new Car(UUID.fromString("124b9220-a47a-45a7-a33b-7182ee0dc30e"), Engine.PETROL, Brand.MAZDA)
//                ,LocalDateTime.now());
    }

    public CarBooking[] getCarBookings() {
        return carBookings;
    }

    public void book(CarBooking carBooking) {
        //TODO
    }
}
