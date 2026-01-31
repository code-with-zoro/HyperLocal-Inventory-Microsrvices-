package com.HyperLocal_Inventory.Search_Service.external.externalDTOs;

import java.util.List;

public class InventorySearchResponseDTO {
    private String productName;
    private List<AllVendorsHaveProduct> products;

    public InventorySearchResponseDTO(String userId, String productName, List<AllVendorsHaveProduct> products) {
        this.productName = productName;
        this.products = products;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<AllVendorsHaveProduct> getProduct() {
        return products;
    }

    public void setProduct(List<AllVendorsHaveProduct> product) {
        this.products = product;
    }

}
