package com.kotenko.cli.booking;

import com.kotenko.cli.car.Car;
import com.kotenko.cli.car.CarService;
import com.kotenko.cli.user.User;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class CarBookingService {
    private final CarBookingDao carBookingDao;
    private final CarService carService;

    public CarBookingService(CarBookingDao carBookingDao, CarService carService) {
        this.carBookingDao = carBookingDao;
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
        CarBooking[] carBookings = carBookingDao.getCarBookings()
                .stream()
                .filter(Objects::nonNull)
                .toArray(CarBooking[]::new);
        if (carBookings.length == 0) {
            System.out.println("No bookings available");
        }
        return carBookingDao.getCarBookings().toArray(CarBooking[]::new);
    }

    public Car[] getAvailableCars() {
        UUID[] bookedCarIds = carBookingDao.getCarBookings()
                .stream()
                .map(it -> it != null ? it.getCar().getId() : null)
                .filter(Objects::nonNull)
                .toArray(UUID[]::new);
        return carService.getCars()
                .stream()
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
        return carBookingDao.getCarBookings()
                .stream()
                .filter(Objects::nonNull)
                .map(CarBooking::getUser)
                .distinct()
                .toArray(User[]::new);
    }
}
