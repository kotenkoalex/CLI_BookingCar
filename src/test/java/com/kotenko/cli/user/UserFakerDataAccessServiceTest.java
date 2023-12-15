package com.kotenko.cli.user;

import com.kotenko.user.UserFakerDataAccessService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFakerDataAccessServiceTest {

    @Test
    void getTwentyUsers() {
        UserFakerDataAccessService service = new UserFakerDataAccessService();
        assertEquals(20, service.getUsers().size());
    }
}