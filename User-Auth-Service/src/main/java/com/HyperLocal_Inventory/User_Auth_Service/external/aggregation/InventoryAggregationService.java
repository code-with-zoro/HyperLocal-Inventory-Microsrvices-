package com.HyperLocal_Inventory.User_Auth_Service.external.aggregation;

import com.HyperLocal_Inventory.User_Auth_Service.entity.UserEntry;
import com.HyperLocal_Inventory.User_Auth_Service.exception.UserDoNotExistsException;
import com.HyperLocal_Inventory.User_Auth_Service.external.InventoryDto.InventoryResponseDto;
import com.HyperLocal_Inventory.User_Auth_Service.external.feginServices.InventoryClient;
import com.HyperLocal_Inventory.User_Auth_Service.repository.UserEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class
InventoryAggregationService {

    private final InventoryClient inventoryClient;
    private final UserEntryRepository userEntryRepository;

    public InventoryAggregationService(InventoryClient inventoryClient, UserEntryRepository userEntryRepository) {
        this.inventoryClient = inventoryClient;
        this.userEntryRepository = userEntryRepository;
    }

    public InventoryResponseDto vendorProducts(String vendorId){
        InventoryResponseDto response = new InventoryResponseDto();
        response.setVendorId(vendorId);
        return inventoryClient.getAll(vendorId);
    }
}
