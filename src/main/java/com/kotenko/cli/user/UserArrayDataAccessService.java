package main.java.com.kotenko.cli.user;

import java.util.List;

public class UserArrayDataAccessService implements UserDao {
    private final List<User> users;

    public UserArrayDataAccessService(IUserReader IUserReader, String path) {
        users = IUserReader.readUsers(path);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
