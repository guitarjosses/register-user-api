package com.jossessoft.user.register.controller;

import com.jossessoft.user.register.business.domain.UserResponse;
import com.jossessoft.user.register.business.service.UserService;
import com.jossessoft.user.register.data.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping("/user")
    public UserResponse createUser(@RequestBody User user){
        return this.userService.addUser(user);
    }
}