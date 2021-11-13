package com.jossessoft.user.register.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jossessoft.user.register.business.domain.UserResponse;
import com.jossessoft.user.register.data.entity.User;
import com.jossessoft.user.register.data.repository.UserRepository;
import com.jossessoft.user.register.exception.AlreadyExistsException;
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
    public UserResponse createUser(@RequestBody User user){

        String regexEmail = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
        Pattern pattern = Pattern.compile(regexEmail, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(user.getEmail());

        if(!matcher.matches())
            throw new BadRequestException("Correo electronico no cumple con el formato");

            User tUser = userRepository.findByEmail(user.getEmail());

            if(tUser != null)
                throw new AlreadyExistsException("El correo ya registrado");

            UserResponse userResponse = new UserResponse(user.getEmail(), user.getUserUUID().toString(), user.getCreated(), user.getModified(), user.getLastLogin(), user.getToken(), user.isActive());
            userRepository.save(user);
            return userResponse;
        
        

    }
}