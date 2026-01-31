package com.HyperLocal_Inventory.Inventory_Service.controllers;

import com.HyperLocal_Inventory.Inventory_Service.DTOs.*;
import com.HyperLocal_Inventory.Inventory_Service.service.SearchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
@Tag(name = "2. Search APIs" ,description = "Authenticated APIs Used For InterServices Operation or After Search Operations")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService service) {
        this.searchService = service;
    }

    @GetMapping
    public ResponseEntity<ProductSearchResponseDTO> searchProduct(@RequestBody ProductSearchRequestDTO toSearch){
        ProductSearchResponseDTO products = searchService.seacrchProduct(toSearch);
        return ResponseEntity.ok().body(products);
    }

    @PostMapping
    public ResponseEntity<SoldResponseDTO> sellingProduct(@RequestBody SellingRequestDTO product){
        SoldResponseDTO soldProduct = searchService.toSell(product);
        return ResponseEntity.ok().body(soldProduct);
    }

    @PostMapping("/product")
    public ResponseEntity<SearchResponseDTO> searchResult(@RequestBody  SearchRequestDTO search){
        SearchResponseDTO searchResult = searchService.searchProduct2(search);
        return ResponseEntity.ok().body(searchResult);
    }

}
