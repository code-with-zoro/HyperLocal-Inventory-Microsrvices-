package com.HyperLocal_Inventory.Inventory_Service.exceptions;

import ch.qos.logback.core.net.SocketConnector;
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
    public ResponseEntity<Map<String,String>> handelGlobalException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(),error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductDoNotExistsException.class)
    public ResponseEntity<Map<String,String>> handelProductDoNotExistsException(ProductDoNotExistsException ex){
        Map<String,String> errors = new HashMap<>();
        log.info("message : "+ex.getMessage());
        errors.put("message : ", ex.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(SellingQuantityMustBePositive.class)
    public ResponseEntity<Map<String,String>> handelSellingMustBePositiveException(SellingQuantityMustBePositive ex){
        Map<String,String> errors = new HashMap<>();
        log.info("message : "+ex.getMessage());
        errors.put("message : ", ex.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(NotEnoughQuantiyPresentInInventory.class)
    public ResponseEntity<Map<String,String>> handelNotEnoughQuantiyPresentInInventory(NotEnoughQuantiyPresentInInventory ex){
        Map<String,String> errors = new HashMap<>();
        log.info("message : "+ex.getMessage());
        errors.put("message : ", ex.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }
}
