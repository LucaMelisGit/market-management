package com.example.user_view.client;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user_view.dto.ProductViewDTO;

@Service
public class ProductClient {
    
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://product-service:8082/products";

    public List<ProductViewDTO> getProductsByMarketId(Long marketId){
        ProductViewDTO[] products = restTemplate.getForObject(
            baseUrl + "/market/" + marketId, 
            ProductViewDTO[].class
        );
        return Arrays.asList(products);
    }

    public List<ProductViewDTO> getProductsByMarketIdAndCategory(Long marketId, String category){
        ProductViewDTO[] products = restTemplate.getForObject(
            baseUrl + "/marketId/" + marketId + "/category/" + category,
            ProductViewDTO[].class
        );
        return Arrays.asList(products);
    }

    public List<ProductViewDTO> getProductsByMarketIdAndExpirationDate(Long marketId, LocalDate expirationDate){
        ProductViewDTO[] products = restTemplate.getForObject(
            baseUrl + "/marketId/" + marketId + "/expirationDate/" + expirationDate,
            ProductViewDTO[].class
        );
        return Arrays.asList(products);
    }

}
