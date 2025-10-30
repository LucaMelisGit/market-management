package com.example.user_view.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductViewDTO {

    private Long id;
    private String category;
    private LocalDate expirationDate;
    private Double price;

    private Long marketId;
    private String marketName;
}
