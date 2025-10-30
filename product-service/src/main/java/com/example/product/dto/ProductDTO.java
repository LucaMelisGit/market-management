package com.example.product.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private Long productId;
    private String category;
    private LocalDate expirationDate;
    private Double price;
    private Long marketId;
}