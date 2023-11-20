package main.java.com.kotenko.cli.car;

import java.util.UUID;

public class CarService {
    private final CarArrayDataAccessService carArrayDataAccessService;

    public CarService() {
        this.carArrayDataAccessService = new CarArrayDataAccessService();
    }

    public Car[] getCars() {
        return carArrayDataAccessService.getCars();
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
