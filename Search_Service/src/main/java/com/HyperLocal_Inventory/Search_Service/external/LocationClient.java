package com.HyperLocal_Inventory.Search_Service.external;

import com.HyperLocal_Inventory.Search_Service.external.externalDTOs.LocationSearchRequestDTO;
import com.HyperLocal_Inventory.Search_Service.external.externalDTOs.LocationSearchResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "location-client" , url = "http://localhost:8083/searchLocation")
public interface LocationClient {

    @PostMapping
    LocationSearchResponseDTO allVendorNearUser(@RequestBody LocationSearchRequestDTO search );
}
