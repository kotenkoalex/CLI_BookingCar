package main.java.com.kotenko.cli.car;

import java.util.UUID;

public class CarArrayDataAccessService implements CarDao{
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

    @Override
    public Car[] getCars(){
        return cars;
    }
}
