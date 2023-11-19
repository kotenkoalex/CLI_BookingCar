package com.kotenko.cli.car;

import java.util.UUID;

public class CarDao {
    private final static Car[] cars;

    static {
        cars = new Car[]{
                new Car(UUID.randomUUID(), Engine.ELECTRIC, Brand.BMW),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.CITROEN),
                new Car(UUID.randomUUID(), Engine.ELECTRIC, Brand.TESLA),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.MERCEDES),
                new Car(UUID.randomUUID(), Engine.PETROL, Brand.MAZDA),
        };
    }

    public Car[] getCars(){
        return cars;
    }
}
