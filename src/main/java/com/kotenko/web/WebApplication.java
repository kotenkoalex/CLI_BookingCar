package com.kotenko.web;

import com.kotenko.core.booking.CarBooking;
import com.kotenko.core.booking.CarBookingArrayDataAccessService;
import com.kotenko.core.booking.CarBookingDao;
import com.kotenko.core.booking.CarBookingService;
import com.kotenko.core.car.*;
import com.kotenko.core.user.User;
import com.kotenko.core.user.UserDao;
import com.kotenko.core.user.UserFakerDataAccessService;
import com.kotenko.core.user.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    private final UserDao userDao = new UserFakerDataAccessService();
    private final UserService service = new UserService(userDao);
    private final CarDao carDao = new CarArrayDataAccessService();
    private final CarService carService = new CarService(carDao);
    private final CarBookingDao carBookingDao = new CarBookingArrayDataAccessService();
    private final CarBookingService carBookingService = new CarBookingService(carBookingDao, carService);

    @GetMapping("/api/users")
    public List<User> viewAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/api/users/booked")
    public List<User> viewAllUserBookedCars() {
        List<User> allUserBookedCars = carBookingService.getAllUserBookedCars();
        return allUserBookedCars.stream().anyMatch(Objects::nonNull) ? allUserBookedCars.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList()) : null;
    }

    @GetMapping("/api/booking")
    public List<CarBooking> viewAllBookings() {
        return carBookingService.getCarBookings().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @GetMapping("/api/cars/available")
    public List<Car> viewAvailableCars() {
        return carBookingService.getAvailableCars();
    }

    @GetMapping("/api/cars/available/electric")
    public List<Car> viewAvailableElectricCars() {
        return carBookingService.getAvailableCars().stream()
                .filter(availableCar -> availableCar.getEngine() == Engine.ELECTRIC)
                .collect(Collectors.toList());
    }
}
