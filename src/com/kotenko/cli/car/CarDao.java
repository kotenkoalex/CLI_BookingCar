package com.kotenko.cli.car;

import java.util.UUID;

public class CarDao {
    private final static Car[] cars;

    static {
        cars = new Car[]{
                new Car(UUID.fromString("114b9220-a47a-45a7-a33b-7182ee0dc30e"), Engine.ELECTRIC, Brand.BMW),
                new Car(UUID.fromString("124b9220-a47a-45a7-a33b-7182ee0dc30e"), Engine.PETROL, Brand.CITROEN),
                new Car(UUID.fromString("134b9220-a47a-45a7-a33b-7182ee0dc30e"), Engine.ELECTRIC, Brand.TESLA),
                new Car(UUID.fromString("144b9220-a47a-45a7-a33b-7182ee0dc30e"), Engine.PETROL, Brand.MERCEDES),
                new Car(UUID.fromString("154b9220-a47a-45a7-a33b-7182ee0dc30e"), Engine.PETROL, Brand.MAZDA),
        };
    }

    public Car[] getCars(){
        return cars;
    }
}
