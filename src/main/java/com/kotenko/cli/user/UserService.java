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
        return this.getUsers().stream()
                .filter(user -> user.getId().equals(UUID.fromString(userId)))
                .findFirst()
                .orElse(null);
    }
}
