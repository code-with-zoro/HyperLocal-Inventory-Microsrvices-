package com.HyperLocal_Inventory.Inventory_Service.service;

import com.HyperLocal_Inventory.Inventory_Service.DTOs.*;
import com.HyperLocal_Inventory.Inventory_Service.entity.ProductEntry;
import com.HyperLocal_Inventory.Inventory_Service.enums.AvailabilityStatus;
import com.HyperLocal_Inventory.Inventory_Service.exceptions.ProductDoNotExistsException;
import com.HyperLocal_Inventory.Inventory_Service.mapper.ProductMapper;
import com.HyperLocal_Inventory.Inventory_Service.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ProductEntryService {

    private final ProductRepository productRepository;

    public ProductEntryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public AllProductResponseDTO all(String vendorId){
        List<AllProductOfAVendor> allProducts = productRepository
                .findByVendorId(vendorId)
                .stream().
                map(ProductMapper :: toallProductOfAVendor).toList();
        return new AllProductResponseDTO(vendorId,allProducts);
    }

    public CreatedResponseDTO createNewProduct(String vendorId,ProductRequestDTO newProduct){
        Optional<ProductEntry> existingProductOpt =
                productRepository.findByVendorIdAndProductNameIgnoreCase(
                        vendorId,
                        newProduct.getProductName()
                );
        if (existingProductOpt.isPresent()) {
            ProductEntry existingProduct = existingProductOpt.get();
            existingProduct.setQuantity(existingProduct.getQuantity() + newProduct.getQuantity());
            existingProduct.setUpdatedAt(LocalDateTime.now());
            ProductEntry saved=productRepository.save(existingProduct);
            return ProductMapper.toCreatedProduct(saved);
        }
      ProductEntry saved = ProductMapper.toModel(newProduct);
       if(saved.getQuantity() == 0) {
           saved.setAvailabilityStatus(AvailabilityStatus.OUT_OF_STOCK);
       }
        saved.setVendorId(vendorId);
        saved.setAvailabilityStatus(AvailabilityStatus.AVALIABLE);
        saved.setCreatedAt(LocalDateTime.now());
        saved.setUpdatedAt(LocalDateTime.now());
        productRepository.save(saved);
        return ProductMapper.toCreatedProduct(saved);
    }
///change this we will not pass product id we will just update based on vendor id and product name if that vendor have that product then update it if not then productdontexistexception
    public UpdateResponseDTO updateProduct(String id , ProductRequestDTO forUpdate){
        ProductEntry toUpdate = productRepository.getByVendorId(id).orElseThrow(()-> new ProductDoNotExistsException("Product Do Not Exits In Inventory Create New Product"));
        if (forUpdate.getProductName() != null) {
            toUpdate.setProductName(forUpdate.getProductName());
        }
        if (forUpdate.getDescription() != null) {
            toUpdate.setDescription(forUpdate.getDescription());
        }
        if (forUpdate.getPrice() != null) {
            toUpdate.setPrice(forUpdate.getPrice());
        }
        if (forUpdate.getQuantity() != null) {
            toUpdate.setQuantity(forUpdate.getQuantity());

            if (forUpdate.getQuantity() == 0) {
                toUpdate.setAvailabilityStatus(AvailabilityStatus.OUT_OF_STOCK);
            }
        }
        toUpdate.setUpdatedAt(LocalDateTime.now()); // given by chat-gpt

        return ProductMapper.toUpdatedProduct(toUpdate);
        /*if(toUpdate.getQuantity() == 0 && forUpdate.getQuantity() == 0){
            toUpdate.setQuantity(0);
            toUpdate.setAvailabilityStatus(AvailabilityStatus.OUT_OF_STOCK);
        }
        toUpdate.setProductName(forUpdate.getProductName());
        toUpdate.setDescription(forUpdate.getDescription());
        toUpdate.setQuantity(toUpdate.getQuantity() + forUpdate.getQuantity());
        toUpdate.setPrice(forUpdate.getPrice());
        toUpdate.setAvailabilityStatus(toUpdate.getAvailabilityStatus());
        toUpdate.setCreatedAt(toUpdate.getCreatedAt());
        toUpdate.setUpdatedAt(LocalDateTime.now());
        productRepository.save(toUpdate);*/ // this was mine approach for updation but the logic is correct but it is nat production grade as it do not complement the full potential of PATCH-MAPPING
    }

    public boolean haveProduct(String vendorId , String productName){
        if(productRepository.existsByVendorIdAndProductNameIgnoreCase(vendorId,productName)){
            return true;
        }
        return false;
    }
}
