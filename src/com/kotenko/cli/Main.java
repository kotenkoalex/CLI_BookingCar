package com.kotenko.cli;

import com.kotenko.cli.booking.CarBooking;
import com.kotenko.cli.booking.CarBookingService;
import com.kotenko.cli.car.Car;
import com.kotenko.cli.car.CarService;
import com.kotenko.cli.car.Engine;
import com.kotenko.cli.user.User;
import com.kotenko.cli.user.UserService;

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
                case 1 -> bookCar();
                case 2 -> viewAllUserBookedCars();
                case 3 -> viewAllBookings(carBookingService.getCarBookings());
                case 4 -> viewAvailableCars(carService.getCars());
                case 5 -> viewAvailableElectricCars(carService.getCars());
                case 6 -> viewAllUsers(userService.getUsers());
                case 7 -> {
                    System.out.println("Good Bye");
                    isActive = false;
                }
                default -> System.out.println("Wrong option\n");
            }
        }
    }

    private static void bookCar() {
        System.out.println("1 Book Car");
    }

    private static void viewAllUserBookedCars() {
        System.out.println("2 View All User Booked Cars");
    }

    private static void viewAllBookings(CarBooking[] carBookings) {
        for (CarBooking carBooking : carBookings) {
            System.out.println(carBooking);
        }
        System.out.println();
    }

    private static void viewAvailableCars(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    private static void viewAvailableElectricCars(Car[] cars) {
        for (Car car : cars) {
            if (car.getEngine() == Engine.ELECTRIC) {
                System.out.println(car);
            }
        }
        System.out.println();
    }

    private static void viewAllUsers(User[] users) {
        for (User user : users) {
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
