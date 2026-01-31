package com.HyperLocal_Inventory.Loaction_Service.DTOs;

import java.util.ArrayList;
import java.util.List;

public class SearchResponseDTO {

    List<String> vendorIds = new ArrayList<>();

    public List<String> getVendorIds() {
        return vendorIds;
    }

    public void setVendorIds(List<String> vendorIds) {
        this.vendorIds = vendorIds;
    }
}
