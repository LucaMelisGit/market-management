package com.example.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.dto.MarketDTO;
import com.example.market.service.MarketService;

@RestController
@RequestMapping("/markets")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @GetMapping
    public List<MarketDTO> getAllMarkets() {
        return marketService.findAll();
    }

    @GetMapping("/{id}")
    public MarketDTO getMarketById(@PathVariable Long id) {
        return marketService.getById(id);
    }
}
