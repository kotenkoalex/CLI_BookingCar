package com.kotenko.core.user;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFakerDataAccessService implements UserDao {
    @Override
    public List<User> getUsers() {
        Faker faker = new Faker();
        int userAmount = 20;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < userAmount; i++) {
            UUID id = UUID.randomUUID();
            String name = faker.name().firstName();
            users.add(new User(id, name));
        }
        return users;
    }
}
