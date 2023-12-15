package com.kotenko.user;

import java.io.File;
import java.util.List;

public class UserArrayDataAccessService implements UserDao {
    private final List<User> users;

    public UserArrayDataAccessService(IUserReader IUserReader, File file) {
        users = IUserReader.readUsers(file);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
