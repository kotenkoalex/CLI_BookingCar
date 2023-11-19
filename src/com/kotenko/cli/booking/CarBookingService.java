package com.kotenko.cli.booking;

import com.kotenko.cli.car.Car;
import com.kotenko.cli.car.CarService;
import com.kotenko.cli.user.User;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class CarBookingService {
    private final CarBookingDao carBookingDao;
    private final CarService carService;

    public CarBookingService(CarService carService) {
        this.carBookingDao = new CarBookingDao();
        this.carService = carService;
    }

    public CarBooking bookCar(User user, Car car) {
        CarBooking carBooking;
        if (user != null && car != null) {
            carBooking = new CarBooking(UUID.randomUUID(), user, car, LocalDateTime.now());
            carBookingDao.book(carBooking);
            return carBooking;
        }
        return null;
    }

    public CarBooking[] getCarBookings() {
        CarBooking[] carBookings = Arrays
                .stream(carBookingDao.getCarBookings())
                .filter(Objects::nonNull)
                .toArray(CarBooking[]::new);
        if (carBookings.length == 0) {
            System.out.println("No bookings available");
        }
        return carBookingDao.getCarBookings();
    }

    public Car[] getAvailableCars() {
        UUID[] bookedCarIds = Arrays
                .stream(carBookingDao.getCarBookings())
                .map(it -> it != null ? it.getCar().getId() : null)
                .filter(Objects::nonNull)
                .toArray(UUID[]::new);
        return Arrays
                .stream(carService.getCars())
                .filter(it -> !containsId(bookedCarIds, it.getId()))
                .toArray(Car[]::new);
    }

    private boolean containsId(UUID[] bookedCarIds, UUID id) {
        for (UUID bookedCarId : bookedCarIds) {
            if (bookedCarId != null && bookedCarId.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public User[] getAllUserBookedCars() {
        return Arrays
                .stream(carBookingDao.getCarBookings())
                .filter(Objects::nonNull)
                .map(CarBooking::getUser)
                .distinct()
                .toArray(User[]::new);
    }
}
