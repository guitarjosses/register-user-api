package com.jossessoft.user.register.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException exception,WebRequest request){
        CustomErrorMessage customErrorMessage = new CustomErrorMessage(exception.getMessage());
        return new ResponseEntity<>(customErrorMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> handleAlreadyExistsException(AlreadyExistsException exception,WebRequest request){
        CustomErrorMessage customErrorMessage = new CustomErrorMessage(exception.getMessage());
        return new ResponseEntity<>(customErrorMessage,HttpStatus.FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exception,WebRequest request){
        CustomErrorMessage customErrorMessage = new CustomErrorMessage(exception.getMessage());
        return new ResponseEntity<>(customErrorMessage,HttpStatus.BAD_REQUEST);
    }
}