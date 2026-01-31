package com.HyperLocal_Inventory.Search_Service.services;


import com.HyperLocal_Inventory.Search_Service.DTOs.UserSearchDTO;
import com.HyperLocal_Inventory.Search_Service.DTOs.UserSearchResultDTO;
import com.HyperLocal_Inventory.Search_Service.external.InventoryClient;
import com.HyperLocal_Inventory.Search_Service.external.LocationClient;
import com.HyperLocal_Inventory.Search_Service.external.externalDTOs.*;
import com.HyperLocal_Inventory.Search_Service.mapper.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchServices {
    private static final Logger log = LoggerFactory.getLogger(SearchServices.class);
    private final InventoryClient inventoryClient;
    private final LocationClient locationClient;

    public SearchServices(InventoryClient inventoryClient, LocationClient locationClient) {
        this.inventoryClient = inventoryClient;
        this.locationClient = locationClient;
    }

    public UserSearchResultDTO searchResult(String userId, UserSearchDTO search){
        int responseLimit= 7;
        Double[] radiusSteps={5d,10d,15d};
        List<AllVendorsHaveProduct> finalResponse = new ArrayList<>();
        Set<String> visitedVendors = new HashSet<>();
        List<String> noDuplicateVendors = new ArrayList<>();
        for(Double radius : radiusSteps) {
            List<String> vendorIds = locationClient.allVendorNearUser(new LocationSearchRequestDTO(userId , radius , 100)).getVendorIds();
            log.info(String.valueOf(vendorIds));

            List<String> newVendors = vendorIds.stream()
                    .filter(v-> !visitedVendors.contains(v))
                    .toList();

                if(newVendors.isEmpty()){
                    continue;
                }
            visitedVendors.addAll(newVendors);

            InventorySearchRequestDTO forSearch = Mapper.toInventorySearch(newVendors , search);
                InventorySearchResponseDTO inventoryResponse = inventoryClient
                        .searchResult(forSearch);

                log.info(String.valueOf(inventoryResponse));
                for(AllVendorsHaveProduct products : inventoryResponse.getProduct()){

                    if(!noDuplicateVendors.contains(products.getVendorId())) {
                        finalResponse.add(products);
                    }
                    noDuplicateVendors.add(products.getVendorId());
                    if(finalResponse.size() >= responseLimit ){
                        break;
                    }
                }
                if(finalResponse.size() >= responseLimit){
                    break;
                }
        }
        if(finalResponse.isEmpty()){
            return new UserSearchResultDTO(search.getProductName() , "No nearby vendors have this product" , new ArrayList<>());
        }
        return new UserSearchResultDTO(search.getProductName() ,"Search Response :- ", finalResponse);
    }
}
