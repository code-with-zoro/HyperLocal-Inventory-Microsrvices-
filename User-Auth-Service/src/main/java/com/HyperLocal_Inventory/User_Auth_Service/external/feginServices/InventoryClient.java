package com.HyperLocal_Inventory.User_Auth_Service.external.feginServices;

import com.HyperLocal_Inventory.User_Auth_Service.external.InventoryDto.InventoryResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-client" , url ="http://localhost:8081" )
public interface InventoryClient {

    @GetMapping("/auth/{vendorId}")
    InventoryResponseDto getAll(@PathVariable String vendorId);
}
