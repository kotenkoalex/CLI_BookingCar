package com.kotenko.cli.booking;

import com.kotenko.cli.car.CarService;
import com.kotenko.cli.user.User;

import java.util.List;
import java.util.UUID;

public class CarBookingService {
    private final CarBookingDao carBookingDao;
    private final CarService carService;

    public CarBookingService(CarBookingDao carBookingDao, CarService carService) {
        this.carBookingDao = carBookingDao;
        this.carService = carService;
    }

    public UUID bookCar(User user, String regNumber){
        List<CarBooking> availableCars = carBookingDao.getCarBookings();
        //TODO
        return null;
    }
}
