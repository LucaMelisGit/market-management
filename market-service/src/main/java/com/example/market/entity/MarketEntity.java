package com.example.market.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "market")
public class MarketEntity {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
}