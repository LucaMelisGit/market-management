package com.example.market.service;

import java.util.List;

import com.example.market.dto.MarketDTO;

public abstract class MarketService {
    
    public abstract List<MarketDTO> findAll();
    public abstract MarketDTO getById(Long id);
}
