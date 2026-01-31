package com.HyperLocal_Inventory.User_Auth_Service.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handelValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors =new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handelEmailAlreadyExistsException (EmailAlreadyExistsException ex){
        log.warn(ex.getMessage());
        Map<String, String> error =new HashMap<>();
        error.put("message : ", "Email already Exists");
        return new ResponseEntity<>(error ,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserDoNotExistsException.class)
    public ResponseEntity<Map<String,String>> handelUserDoNotExistsException( UserDoNotExistsException ex){
        log.warn(ex.getMessage());
        Map<String, String> error =new HashMap<>();
        error.put("message : ", "User Do Not Exists");
        return new ResponseEntity<>(error ,HttpStatus.BAD_REQUEST);
    }
}
