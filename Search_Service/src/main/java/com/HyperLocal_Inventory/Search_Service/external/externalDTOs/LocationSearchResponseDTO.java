package com.HyperLocal_Inventory.Search_Service.external.externalDTOs;

import java.util.ArrayList;
import java.util.List;

public class LocationSearchResponseDTO {

    private List<String> vendorIds;

    public List<String> getVendorIds() {
        return vendorIds;
    }

    public void setVendorIds(List<String> vendorIds) {
        this.vendorIds = vendorIds;
    }
}
