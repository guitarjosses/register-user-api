package com.jossessoft.user.register.business.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jossessoft.user.register.business.domain.UserResponse;
import com.jossessoft.user.register.data.entity.User;
import com.jossessoft.user.register.data.repository.UserRepository;
import com.jossessoft.user.register.exception.AlreadyExistsException;
import com.jossessoft.user.register.exception.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse addUser(User user) {
        
            validateValidEmail(user.getEmail());

            User tUser = userRepository.findByEmail(user.getEmail());

            if(tUser != null)
                throw new AlreadyExistsException("El correo ya registrado");

                user.setToken(user.getUserUUID());

            UserResponse userResponse = new UserResponse(user.getEmail(), user.getUserUUID().toString(), user.getCreated(), user.getModified(), user.getLastLogin(), user.getToken(), user.isActive());
            userRepository.save(user);
            return userResponse;
    }

    @Override
    public Iterable<User> getAllUsers() {
        
        return this.userRepository.findAll();
    }

    private void validateValidEmail(String email) {
        String regexEmail = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
        Pattern pattern = Pattern.compile(regexEmail, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        if(!matcher.matches())
            throw new BadRequestException("Correo electronico no cumple con el formato");
    }
    
}