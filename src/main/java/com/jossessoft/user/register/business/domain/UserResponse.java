package com.jossessoft.user.register.business.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

    private String user;
    private String id;
    private Date created;
    private Date modified;
    private Date last_login;
    private String token;
    private boolean isactive;
    
}