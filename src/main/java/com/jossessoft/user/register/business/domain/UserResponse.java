package com.jossessoft.user.register.business.domain;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.Type;

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
    @Type(type="uuid-char")
    private UUID token;
    private boolean isactive;
    
}