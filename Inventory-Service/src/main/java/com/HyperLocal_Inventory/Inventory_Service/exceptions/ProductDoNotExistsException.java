package com.HyperLocal_Inventory.Inventory_Service.exceptions;

public class ProductDoNotExistsException extends RuntimeException{

    public ProductDoNotExistsException(String message){
        super(message);
    }
}
