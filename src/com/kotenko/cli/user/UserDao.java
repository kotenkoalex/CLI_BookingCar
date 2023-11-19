package com.kotenko.cli.user;

import java.util.UUID;

public class UserDao {
    private static final User[] users;

    static {
        users = new User[]{
                new User(UUID.randomUUID(), "Alex"),
                new User(UUID.randomUUID(), "Mark"),
        };
    }

    public User[] getUsers() {
        return users;
    }
}
