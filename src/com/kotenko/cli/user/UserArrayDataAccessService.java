package com.kotenko.cli.user;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class UserArrayDataAccessService implements UserDao {
    private static final User[] users;

    static {
        Path path = Paths.get("src/com/kotenko/cli/user/users.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            users = new User[(int) Files.lines(path).count()];
            String line;
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                users[counter++] = new User(UUID.fromString(data[0]), data[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User[] getUsers() {
        return users;
    }
}
