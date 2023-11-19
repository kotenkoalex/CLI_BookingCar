package com.kotenko.cli.user;

import java.util.UUID;

public class UserService {
    private final UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public User[] getUsers() {
        return userDao.getUsers();
    }

    public User getUserById(String userId) throws IllegalArgumentException {
        for (User user : this.getUsers()) {
            if (user.getId().equals(UUID.fromString(userId))) {
                return user;
            }
        }
        return null;
    }
}
