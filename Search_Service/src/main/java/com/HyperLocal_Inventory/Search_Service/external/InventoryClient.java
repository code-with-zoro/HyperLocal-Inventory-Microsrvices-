package com.HyperLocal_Inventory.Search_Service.external;


import com.HyperLocal_Inventory.Search_Service.external.externalDTOs.InventorySearchRequestDTO;
import com.HyperLocal_Inventory.Search_Service.external.externalDTOs.InventorySearchResponseDTO;
import org.slf4j.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "inventory-client" , url = "http://localhost:8082")
public interface InventoryClient {

    @PostMapping("/search/product")
    InventorySearchResponseDTO searchResult(@RequestBody InventorySearchRequestDTO search);

}
