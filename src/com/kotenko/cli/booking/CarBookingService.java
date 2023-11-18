package com.kotenko.cli.booking;

import com.kotenko.cli.car.CarService;
import com.kotenko.cli.user.User;

import java.util.UUID;

public class CarBookingService {
    private final CarBookingDao carBookingDao;
    private final CarService carService;

    public CarBookingService(CarService carService) {
        this.carBookingDao = new CarBookingDao();
        this.carService = carService;
    }

    public UUID bookCar(User user, String regNumber){
        //TODO
        return null;
    }

    public CarBooking[] getCarBookings() {
        return carBookingDao.getCarBookings();
    }
}
