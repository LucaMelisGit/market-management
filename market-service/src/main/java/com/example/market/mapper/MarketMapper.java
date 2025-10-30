package com.example.market.mapper;

import com.example.market.dto.MarketDTO;
import com.example.market.entity.MarketEntity;

public class MarketMapper {
    
    public static MarketDTO convertEntityToDTO(MarketEntity entity){
        MarketDTO dto = new MarketDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        return dto;
    }

    public static MarketEntity convertDTOToEntity(MarketDTO dto){
        MarketEntity entity = new MarketEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        return entity;
    }
}
