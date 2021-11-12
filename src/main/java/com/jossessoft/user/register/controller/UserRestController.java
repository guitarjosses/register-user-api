package com.jossessoft.user.register.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jossessoft.user.register.data.entity.User;
import com.jossessoft.user.register.data.repository.UserRepository;
import com.jossessoft.user.register.exception.BadRequestException;

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
    private UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return this.userRepository.findAll();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){

        String regexEmail = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(user.getEmail());

        if(!matcher.matches())
            throw new BadRequestException("Correo electronico no cumple con el formato");

        if(user.getName()==null || user.getName().isEmpty()){
            throw new BadRequestException("Debe proporcionar un nombre");
            
        }else{
            
            return userRepository.save(user);
        }
        

    }
}