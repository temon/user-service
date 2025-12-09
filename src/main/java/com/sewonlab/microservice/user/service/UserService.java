package com.sewonlab.microservice.user.service;

import com.sewonlab.microservice.user.exception.UserNotFoundException;
import com.sewonlab.microservice.user.model.User;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserService {

    private List<User> users = new ArrayList<>();

    public User create(User user) {
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(Integer id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    public User updateUser(Integer id, User user) {
        User oldUser = getUser(id);
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setMobileNumber(user.getMobileNumber());
        return oldUser;
    }

    public void deleteUser(Integer id) {
        users.removeIf(user -> user.getId() == id);
    }
}
