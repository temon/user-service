package com.sewonlab.microservice.user.controller;

import com.sewonlab.microservice.user.model.User;
import com.sewonlab.microservice.user.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@Controller("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Post
    public HttpResponse<User> createUser(@Body @Valid User user) {
        return HttpResponse.created(userService.create(user));
    }

    @Get
    public HttpResponse<List<User>> getAllUsers() {
        return HttpResponse.ok(userService.getAllUsers());
    }

    @Get("/{id}")
    public HttpResponse<User> getUserById(@PathVariable Integer id) {
        return HttpResponse.ok(userService.getUser(id));
    }

    @Put("/{id}")
    public HttpResponse<User> updateUser(@PathVariable Integer id, @Body @Valid User user) {
        return HttpResponse.ok(userService.updateUser(id, user));
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return HttpResponse.ok();
    }
}
