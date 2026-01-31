package com.HyperLocal_Inventory.Inventory_Service.mapper;

import com.HyperLocal_Inventory.Inventory_Service.DTOs.*;
import com.HyperLocal_Inventory.Inventory_Service.entity.ProductEntry;

import java.time.LocalDateTime;

public class ProductMapper {

    public static ProductEntry toModel(ProductRequestDTO newProduct){
        ProductEntry toAdd = new ProductEntry();
        /*toAdd.setVendorId(newProduct.getVendorId());*/
        toAdd.setProductName(newProduct.getProductName());
        toAdd.setDescription(newProduct.getDescription());
        toAdd.setPrice(newProduct.getPrice());
        toAdd.setQuantity(newProduct.getQuantity());
        /*toAdd.setAvailabilityStatus(newProduct.getAvailabilityStatus());
        toAdd.setCreatedAt(newProduct.getCreatedAt());
        toAdd.setUpdatedAt(newProduct.getUpdatedAt());*/
        return toAdd;
    }

    public static CreatedResponseDTO toCreatedProduct(ProductEntry newProduct){
        CreatedResponseDTO createdProduct = new CreatedResponseDTO();
        createdProduct.setVendorId(newProduct.getVendorId());
        createdProduct.setProductName(newProduct.getProductName());
        createdProduct.setDescription(newProduct.getDescription());
        createdProduct.setPrice(newProduct.getPrice());
        createdProduct.setAvailabilityStatus(newProduct.getAvailabilityStatus());
        createdProduct.setQuantity(newProduct.getQuantity());
        createdProduct.setCreatedAt(newProduct.getCreatedAt());
        return createdProduct;
    }

    public static AllProductOfAVendor toallProductOfAVendor(ProductEntry allProducts){
        AllProductOfAVendor products = new AllProductOfAVendor();
        products.setProductName(allProducts.getProductName());
        products.setDescription(allProducts.getDescription());
        products.setPrice(allProducts.getPrice());
        products.setAvailabilityStatus(allProducts.getAvailabilityStatus());
        return products;
    }

    public static UpdateResponseDTO toUpdatedProduct(ProductEntry toUpdate){
        UpdateResponseDTO updated = new UpdateResponseDTO();
        updated.setVendorId(toUpdate.getVendorId());
        updated.setProductName(toUpdate.getProductName());
        updated.setDescription(toUpdate.getDescription());
        updated.setPrice(toUpdate.getPrice());
        updated.setAvailabilityStatus(toUpdate.getAvailabilityStatus());
        updated.setQuantity(toUpdate.getQuantity());
        updated.setCreatedAt(toUpdate.getCreatedAt());
        updated.setUpdatedAt(toUpdate.getUpdatedAt());
        return updated;
    }
    public static AllVendorsHaveProduct toSearchResponse (ProductEntry searchedProduct){
       AllVendorsHaveProduct products = new AllVendorsHaveProduct();
       products.setVendorId(searchedProduct.getVendorId());
       products.setProductName(searchedProduct.getProductName());
       products.setDescription(searchedProduct.getDescription());
       products.setPrice(searchedProduct.getPrice());
       products.setAvailabilityStatus(searchedProduct.getAvailabilityStatus());
       return products;
    }

    public static SoldResponseDTO afterSelling(ProductEntry toSell){
        SoldResponseDTO sold = new SoldResponseDTO();
        sold.setVendorId(toSell.getVendorId());
        sold.setProductName(toSell.getProductName());
        sold.setDescription(toSell.getDescription());
        sold.setPrice(toSell.getPrice());
        sold.setLeftQuantity(toSell.getQuantity());
        sold.setAvailabilityStatus(toSell.getAvailabilityStatus());
        sold.setUpdatedAt(toSell.getUpdatedAt());
        sold.setSoldAt(LocalDateTime.now());
        return sold;
    }
}
