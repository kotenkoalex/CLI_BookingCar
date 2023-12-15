package com.kotenko.cli.car;

import com.kotenko.car.CarArrayDataAccessService;
import com.kotenko.car.CarDao;
import com.kotenko.car.CarService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    private final CarDao dao = new CarArrayDataAccessService();
    private final CarService service = new CarService(dao);

    @Test
    void getFiveCars() {
        assertEquals(5, service.getCars().size());
    }

    @Disabled
    @Test
    void getCarById() {
        //for now not implemented because UUID id is generated each time
    }
}