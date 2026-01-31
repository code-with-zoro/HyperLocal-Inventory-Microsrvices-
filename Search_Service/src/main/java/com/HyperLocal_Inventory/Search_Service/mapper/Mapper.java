package com.HyperLocal_Inventory.Search_Service.mapper;

import com.HyperLocal_Inventory.Search_Service.DTOs.UserSearchDTO;
import com.HyperLocal_Inventory.Search_Service.DTOs.UserSearchResultDTO;
import com.HyperLocal_Inventory.Search_Service.external.externalDTOs.AllVendorsHaveProduct;
import com.HyperLocal_Inventory.Search_Service.external.externalDTOs.InventorySearchRequestDTO;
import com.HyperLocal_Inventory.Search_Service.external.externalDTOs.InventorySearchResponseDTO;

import java.util.List;

public class Mapper {

    public static InventorySearchRequestDTO toInventorySearch(List<String> vendorIds , UserSearchDTO search){
        InventorySearchRequestDTO newSearch = new InventorySearchRequestDTO();
        newSearch.setVendorIds(vendorIds);
        newSearch.setProductName(search.getProductName());
        newSearch.setQuantity(search.getQuantity());
        return newSearch;
    }


}
