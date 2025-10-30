package com.example.product.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.dto.ProductDTO;
import com.example.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/market/{market}")
    public List<ProductDTO> getAllProducts(@PathVariable Long marketId){
        return productService.findAllByMarketId(marketId);
    }

    @GetMapping("/market/{market}/category/{category}")
    public List<ProductDTO> getAllByCategory(@PathVariable Long marketId, @PathVariable String category){
        return productService.getAllByMarketIdAndCategory(marketId, category);
    }

    @GetMapping("/market/{market}/expirationDate/{expirationDate}")
    public List<ProductDTO> getAllByExpitationDate(@PathVariable Long marketId, @PathVariable LocalDate expirationDate){
        return productService.getAllByMarketIdAndExpitationDate(marketId, expirationDate);
    }
}
