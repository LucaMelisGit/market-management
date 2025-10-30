package com.example.product.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "product_id")
    private Long productId;
    private String category;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    private Double price;

    @Column(name = "market_id")
    private Long marketId;
}
