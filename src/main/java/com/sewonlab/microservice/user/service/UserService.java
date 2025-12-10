package com.sewonlab.microservice.user.service;

import com.sewonlab.microservice.user.exception.UserNotFoundException;
import com.sewonlab.microservice.user.model.User;
import com.sewonlab.microservice.user.repository.UserRepository;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        return  userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User updateUser(Integer id, User user) {
        User oldUser = getUser(id);
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setMobileNumber(user.getMobileNumber());
        return userRepository.update(oldUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
