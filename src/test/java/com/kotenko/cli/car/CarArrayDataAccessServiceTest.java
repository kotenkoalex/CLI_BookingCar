package com.kotenko.cli.car;

import com.kotenko.core.car.CarArrayDataAccessService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarArrayDataAccessServiceTest {

    @Test
    void getFiveCars() {
        CarArrayDataAccessService service = new CarArrayDataAccessService();
        assertEquals(5, service.getCars().size());
    }
}