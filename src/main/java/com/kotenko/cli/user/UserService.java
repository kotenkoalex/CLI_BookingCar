package main.java.com.kotenko.cli.user;

import java.util.List;
import java.util.UUID;

public class UserService {
    private final UserArrayDataAccessService userArrayDataAccessService;

    public UserService(UserArrayDataAccessService userArrayDataAccessService) {
        this.userArrayDataAccessService = userArrayDataAccessService;
    }

    public List<User> getUsers() {
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
