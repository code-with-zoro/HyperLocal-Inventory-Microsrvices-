package com.HyperLocal_Inventory.Inventory_Service.exceptions;

public class NotEnoughQuantiyPresentInInventory extends RuntimeException{
    public NotEnoughQuantiyPresentInInventory (String message){
        super(message);
    }
}
