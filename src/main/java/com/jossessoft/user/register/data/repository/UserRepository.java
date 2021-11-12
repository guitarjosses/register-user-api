package com.jossessoft.user.register.data.repository;

import java.util.UUID;

import com.jossessoft.user.register.data.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,UUID>{
    
}