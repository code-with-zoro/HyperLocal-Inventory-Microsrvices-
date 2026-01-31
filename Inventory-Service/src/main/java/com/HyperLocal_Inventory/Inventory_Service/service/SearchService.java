package com.HyperLocal_Inventory.Inventory_Service.service;

import com.HyperLocal_Inventory.Inventory_Service.DTOs.*;
import com.HyperLocal_Inventory.Inventory_Service.entity.ProductEntry;
import com.HyperLocal_Inventory.Inventory_Service.enums.AvailabilityStatus;
import com.HyperLocal_Inventory.Inventory_Service.exceptions.NotEnoughQuantiyPresentInInventory;
import com.HyperLocal_Inventory.Inventory_Service.exceptions.ProductDoNotExistsException;
import com.HyperLocal_Inventory.Inventory_Service.exceptions.SellingQuantityMustBePositive;
import com.HyperLocal_Inventory.Inventory_Service.mapper.ProductMapper;
import com.HyperLocal_Inventory.Inventory_Service.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    private static final Logger log = LoggerFactory.getLogger(SearchService.class);
    private final ProductRepository productRepository;
    private final ProductEntryService productEntryService;

    public SearchService(ProductRepository productRepository, ProductEntryService productEntryService) {
        this.productRepository = productRepository;
        this.productEntryService = productEntryService;
    }

    public ProductSearchResponseDTO seacrchProduct(ProductSearchRequestDTO toSearch){
      List<AllVendorsHaveProduct> products = productRepository
              .findByProductNameIgnoreCase(toSearch.getProductName())
              .stream()
              .map(ProductMapper :: toSearchResponse).toList();
      return new ProductSearchResponseDTO(toSearch.getProductName(), products);
    }
    

    public SoldResponseDTO toSell(SellingRequestDTO product){
        ProductEntry toSell = productRepository
                .findByVendorIdAndProductNameIgnoreCase(product.getVendorId(), product.getProductName())
                .orElseThrow(()-> new ProductDoNotExistsException("Product do Not exist"));
        if(product.getDemandQuantity() <=0 ){
            throw new SellingQuantityMustBePositive("Quantity Must be >= 1 ");
        }
        if(toSell.getAvailabilityStatus() != AvailabilityStatus.AVALIABLE || toSell.getQuantity() < product.getDemandQuantity()){
            throw new NotEnoughQuantiyPresentInInventory("Not Enough Stock is avalible in Inventory");
        }

        toSell.setQuantity(toSell.getQuantity() - product.getDemandQuantity());

        if(toSell.getQuantity() == 0){
            toSell.setAvailabilityStatus(AvailabilityStatus.OUT_OF_STOCK);
        }
        toSell.setUpdatedAt(LocalDateTime.now());
        productRepository.save(toSell);
        SoldResponseDTO sold = ProductMapper.afterSelling(toSell);
        return sold;
    }

    public SearchResponseDTO searchProduct2(SearchRequestDTO search){
        List<String> idsHaveproduct = new ArrayList<>();
        List<AllVendorsHaveProduct> products = new ArrayList<>();

        log.info(String.valueOf(search.getVendorIds()));

        for(String ids : search.getVendorIds()){
            if(productEntryService.haveProduct(ids, search.getProductName())){
                idsHaveproduct.add(ids);
            }
        }
        log.info(String.valueOf(idsHaveproduct));
        for (String id : idsHaveproduct){
            ProductEntry byVendorIdAndProductName = productRepository.getByVendorIdAndProductNameIgnoreCase(id, search.getProductName());
            products.add(ProductMapper.toSearchResponse(byVendorIdAndProductName));
        }
        SearchResponseDTO searches = new SearchResponseDTO( search.getProductName(), products);
        return searches;
    }


}
