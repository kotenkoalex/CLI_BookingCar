package main.java.com.kotenko.cli.car;

import java.util.Objects;
import java.util.UUID;

public class Car {
    private UUID id;
    private Engine engine;
    private Brand brand;

    public Car(UUID id, Engine engine, Brand brand) {
        this.id = id;
        this.engine = engine;
        this.brand = brand;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + id + '\'' +
                ", engine=" + engine +
                ", brand=" + brand +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && engine == car.engine && brand == car.brand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, engine, brand);
    }
}
