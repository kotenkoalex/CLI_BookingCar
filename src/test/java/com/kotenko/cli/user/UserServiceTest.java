package com.kotenko.cli.user;

import com.kotenko.user.UserDao;
import com.kotenko.user.UserFakerDataAccessService;
import com.kotenko.user.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private final UserDao userDao = new UserFakerDataAccessService();
    private final UserService service = new UserService(userDao);

    @Test
    void getTwentyUsers() {
        assertEquals(20, service.getUsers().size());
    }

    @Disabled
    @Test
    void getUserById() {
        //for now not implemented because UUID id is generated each time
    }
}