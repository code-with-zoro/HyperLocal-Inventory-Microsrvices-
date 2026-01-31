package com.HyperLocal_Inventory.Inventory_Service.repository;

import com.HyperLocal_Inventory.Inventory_Service.DTOs.AllProductOfAVendor;
import com.HyperLocal_Inventory.Inventory_Service.entity.ProductEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<ProductEntry, ObjectId> {

    Optional<ProductEntry> findByVendorIdAndProductNameIgnoreCase(String vendorId, String productName);

    List<ProductEntry> findByVendorId(String vendorId);

    List<ProductEntry> findByProductNameIgnoreCase(String productName);

    Optional<ProductEntry> getByVendorId(String id);

    Boolean existsByVendorIdAndProductNameIgnoreCase(String vendorId , String productName);

    ProductEntry getByVendorIdAndProductNameIgnoreCase(String id, String productName);

}
