package com.jossessoft.user.register.business.service;

import com.jossessoft.user.register.business.domain.UserResponse;
import com.jossessoft.user.register.data.entity.User;

public interface UserService {
    
    UserResponse addUser(User user);
    Iterable<User> getAllUsers();
}