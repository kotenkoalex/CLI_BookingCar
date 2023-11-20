package main.java.com.kotenko.cli.user;

import java.util.UUID;

public class UserService {
    private final UserArrayDataAccessService userArrayDataAccessService;

    public UserService() {
        this.userArrayDataAccessService = new UserArrayDataAccessService();
    }

    public User[] getUsers() {
        return userArrayDataAccessService.getUsers();
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
