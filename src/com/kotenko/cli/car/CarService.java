package com.kotenko.cli.car;

public class CarService {
    private final CarDao carDao;

    public CarService() {
        this.carDao = new CarDao();
    }

    public Car[] getCars() {
        return carDao.getCars();
    }
}
