package com.kotenko.car;

import java.util.List;
import java.util.UUID;

public class CarArrayDataAccessService implements CarDao {
    private final static List<Car> cars;

    static {
        cars = List.of(
                new Car(UUID.randomUUID(), Engine.ELECTRIC, Brand.BMW),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.CITROEN),
                new Car(UUID.randomUUID(), Engine.ELECTRIC, Brand.TESLA),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.MERCEDES),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.MAZDA));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
}
