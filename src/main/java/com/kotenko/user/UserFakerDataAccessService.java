package com.kotenko.user;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFakerDataAccessService implements UserDao {
    private List<User> users;

    @Override
    public List<User> getUsers() {
        if (users == null) {
            Faker faker = new Faker();
            int userAmount = 20;
            List<User> users = new ArrayList<>();
            for (int i = 0; i < userAmount; i++) {
                UUID id = UUID.randomUUID();
                String name = faker.name().firstName();
                users.add(new User(id, name));
            }
            return this.users = users;
        } else {
            return this.users;
        }
    }
}
