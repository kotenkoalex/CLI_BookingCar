package com.kotenko.cli;

import com.kotenko.cli.car.CarBookingDao;
import com.kotenko.cli.car.CarBookingService;
import com.kotenko.cli.car.CarDao;
import com.kotenko.cli.car.CarService;
import com.kotenko.cli.user.UserArrayDataAccessService;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        CarBookingDao carBookingDao = new CarBookingDao();
        CarDao carDao = new CarDao();
        CarService carService = new CarService(carDao);
        CarBookingService carBookingService = new CarBookingService(carBookingDao, carService);

        UserArrayDataAccessService userArrayDataAccessService = new UserArrayDataAccessService();
        System.out.println(
                Arrays.toString(
                        userArrayDataAccessService.getUsers()));

//        Scanner scanner = new Scanner(System.in);
//        boolean isWork = true;
//        while (scanner.hasNext()) {
//            System.out.println("""
//                    1️⃣ - Book Car
//                    2️⃣ - View All User Booked Cars
//                    3️⃣ - View All Bookings
//                    4️⃣ - View Available Cars
//                    5️⃣ - View Available Electric Cars
//                    6️⃣ - View all users
//                    7️⃣ - Exit
//                    """.trim()
//            );
//        }
    }
}