package com.HyperLocal_Inventory.Inventory_Service.DTOs;

import java.util.List;

public class ProductSearchResponseDTO {
    private String productName;
    private List<AllVendorsHaveProduct> products;


    public ProductSearchResponseDTO(String productName, List<AllVendorsHaveProduct> product) {
        this.productName = productName;
        this.products = product;
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
