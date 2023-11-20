package main.java.com.kotenko.cli;

import main.java.com.kotenko.cli.booking.CarBooking;
import main.java.com.kotenko.cli.booking.CarBookingService;
import main.java.com.kotenko.cli.car.Car;
import main.java.com.kotenko.cli.car.CarService;
import main.java.com.kotenko.cli.car.Engine;
import main.java.com.kotenko.cli.user.User;
import main.java.com.kotenko.cli.user.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        CarService carService = new CarService();
        CarBookingService carBookingService = new CarBookingService(carService);

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
        for (User user : carBookingService.getAllUserBookedCars()) {
            if (user != null) {
                System.out.println(user);
            }
        }
        System.out.println();
    }

    private static void viewAllBookings(CarBookingService carBookings) {
        for (CarBooking carBooking : carBookings.getCarBookings()) {
            if (carBooking != null) {
                System.out.println(carBooking);
            }
        }
        System.out.println();
    }

    private static void viewAvailableCars(CarBookingService carBookings) {
        for (Car availableCar : carBookings.getAvailableCars()) {
            System.out.println(availableCar);
        }
        System.out.println();
    }

    private static void viewAvailableElectricCars(CarBookingService carBookings) {
        for (Car availableCar : carBookings.getAvailableCars()) {
            if (availableCar.getEngine() == Engine.ELECTRIC) {
                System.out.println(availableCar);
            }
        }
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
