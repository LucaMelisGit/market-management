package com.example.market.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.dto.MarketDTO;
import com.example.market.mapper.MarketMapper;
import com.example.market.repository.MarketRepository;
import com.example.market.service.MarketService;

@Service
public class MarketServiceImpl extends MarketService{

    @Autowired
    private MarketRepository marketRepository;

    @Override
    public List<MarketDTO> findAll() {
        return marketRepository.findAll().stream()
                .map(MarketMapper::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MarketDTO getById(Long id) {
        return marketRepository.findById(id)
                .map(MarketMapper::convertEntityToDTO)
                .orElse(null);
    }
}
