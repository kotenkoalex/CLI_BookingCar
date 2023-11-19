package com.kotenko.cli.car;

import java.util.UUID;

public class CarService {
    private final CarDao carDao;

    public CarService() {
        this.carDao = new CarDao();
    }

    public Car[] getCars() {
        return carDao.getCars();
    }

    public Car getCarById(String carId) throws IllegalArgumentException {
        for (Car car : this.getCars()) {
            if (car.getId().equals(UUID.fromString(carId))) {
                return car;
            }
        }
        return null;
    }
}
