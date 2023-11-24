package com.kotenko.cli;

import com.kotenko.cli.booking.CarBooking;
import com.kotenko.cli.booking.CarBookingArrayDataAccessService;
import com.kotenko.cli.booking.CarBookingDao;
import com.kotenko.cli.booking.CarBookingService;
import com.kotenko.cli.car.CarArrayDataAccessService;
import com.kotenko.cli.car.CarDao;
import com.kotenko.cli.car.CarService;
import com.kotenko.cli.car.Engine;
import com.kotenko.cli.user.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        File file = new File(Main.class.getClassLoader().getResource("users.csv").getPath());
//        UserDao users = new UserArrayDataAccessService(new UserReaderFromFile(), file);
        UserDao users = new UserFakerDataAccessService();
        UserService userService = new UserService(users);
        CarDao cars = new CarArrayDataAccessService();
        CarService carService = new CarService(cars);
        CarBookingDao carsBooking = new CarBookingArrayDataAccessService();
        CarBookingService carBookingService = new CarBookingService(carsBooking, carService);
        boolean isActive = true;
        Scanner scanner = new Scanner(System.in);
        while (isActive) {
            showOptions();
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> bookCar(userService, carService, carBookingService);
                case 2 -> viewAllUserBookedCars(carBookingService);
                case 3 -> viewAllBookings(carBookingService);
                case 4 -> viewAvailableCars(carBookingService);
                case 5 -> viewAvailableElectricCars(carBookingService);
                case 6 -> viewAllUsers(userService);
                case 7 -> {
                    System.out.println("Good Bye");
                    isActive = false;
                }
                default -> System.out.println("Wrong option\n");
            }
        }
    }

    private static void bookCar(UserService userService, CarService carService, CarBookingService carBookingService) {
        Scanner scanner = new Scanner(System.in);
        viewAvailableCars(carBookingService);
        String carId = scanner.nextLine();
        viewAllUsers(userService);
        String userId = scanner.nextLine();

        CarBooking carBooking;
        try {
            carBooking = carBookingService.bookCar(
                    userService.getUserById(userId),
                    carService.getCarById(carId)
            );
            System.out.println("Car has successfully booked");
            System.out.println(carBooking);
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect id, try again");
        }
        System.out.println();
    }

    private static void viewAllUserBookedCars(CarBookingService carBookingService) {
        User[] allUserBookedCars = carBookingService.getAllUserBookedCars();
        if (containsNotNullElement(allUserBookedCars)) {
            Arrays
                    .stream(allUserBookedCars)
                    .filter(Objects::nonNull)
                    .forEach(System.out::println);
        } else {
            System.out.println("No users booked car");
        }
        System.out.println();
    }

    private static boolean containsNotNullElement(User[] allUserBookedCars) {
        return Arrays
                .stream(allUserBookedCars)
                .anyMatch(Objects::nonNull);
    }

    private static void viewAllBookings(CarBookingService carBookings) {
        Arrays
                .stream(carBookings.getCarBookings())
                .filter(Objects::nonNull)
                .forEach(System.out::println);
        System.out.println();
    }

    private static void viewAvailableCars(CarBookingService carBookings) {
        Arrays
                .stream(carBookings.getAvailableCars())
                .forEach(System.out::println);
        System.out.println();
    }

    private static void viewAvailableElectricCars(CarBookingService carBookings) {
        Arrays
                .stream(carBookings.getAvailableCars())
                .filter(availableCar -> availableCar.getEngine() == Engine.ELECTRIC)
                .forEach(System.out::println);
        System.out.println();
    }

    private static void viewAllUsers(UserService users) {
        for (User user : users.getUsers()) {
            System.out.println(user);
        }
        System.out.println();
    }

    private static void showOptions() {
        System.out.println("""
                1️⃣ - Book Car
                2️⃣ - View All User Booked Cars
                3️⃣ - View All Bookings
                4️⃣ - View Available Cars
                5️⃣ - View Available Electric Cars
                6️⃣ - View all users
                7️⃣ - Exit
                """.trim());
    }
}
