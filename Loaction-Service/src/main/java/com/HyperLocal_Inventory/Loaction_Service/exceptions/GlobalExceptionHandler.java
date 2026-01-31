package com.HyperLocal_Inventory.Loaction_Service.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public ResponseEntity<Map<String,String>> handelGlobalExceptionHandler(MethodArgumentNotValidException ex){
        log.warn(ex.getMessage());
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(),error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,String>> handelUserNotFoundException(UserNotFoundException ex){
        log.info(ex.getMessage());
        Map<String,String> errors = new HashMap<>();
        errors.put("message : ", ex.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handelUserAlreadyExistsException(UserAlreadyExistsException ex){
        log.info(ex.getMessage());
        Map<String,String> errors = new HashMap<>();
        errors.put("message : ", ex.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }
}
