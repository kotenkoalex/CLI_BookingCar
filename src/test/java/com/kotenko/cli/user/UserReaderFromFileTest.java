package com.kotenko.cli.user;

import com.kotenko.core.user.UserReaderFromFile;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class UserReaderFromFileTest {

    @Test
    void readFourUsersFromFile() {
        UserReaderFromFile reader = new UserReaderFromFile();
        File file = new File(UserReaderFromFileTest.class.getClassLoader().getResource("users.csv").getPath());
        assertEquals(4, reader.readUsers(file).size());
    }
}