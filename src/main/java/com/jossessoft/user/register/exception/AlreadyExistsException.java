package com.jossessoft.user.register.exception;

public class AlreadyExistsException extends RuntimeException{
    
    public AlreadyExistsException(String message){
        super(message);
    }
}