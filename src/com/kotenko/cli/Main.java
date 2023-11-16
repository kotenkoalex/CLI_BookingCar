package com.kotenko.cli;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isWork = true;
        while (scanner.hasNext()) {
            System.out.println("""
                    1️⃣ - Book Car
                    2️⃣ - View All User Booked Cars
                    3️⃣ - View All Bookings
                    4️⃣ - View Available Cars
                    5️⃣ - View Available Electric Cars
                    6️⃣ - View all users
                    7️⃣ - Exit
                    """.trim()
            );
        }


    }
}