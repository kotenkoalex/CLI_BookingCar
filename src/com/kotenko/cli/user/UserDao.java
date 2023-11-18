package com.kotenko.cli.user;

import java.util.UUID;

public class UserDao {
    private static final User[] users;

    static {
        users = new User[]{
                new User(UUID.fromString("1e4b9220-a47a-45a7-a33b-7182ee0dc30e"), "Alex"),
                new User(UUID.fromString("2e4b9220-a47a-45a7-a33b-7182ee0dc30e"), "Mark"),
        };
    }

    public User[] getUsers() {
        return users;
    }
}
