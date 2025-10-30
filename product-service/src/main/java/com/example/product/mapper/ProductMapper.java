package com.example.product.mapper;

import com.example.product.dto.ProductDTO;
import com.example.product.entity.ProductEntity;

public class ProductMapper {
    
    public static ProductDTO convertEntityToDTO(ProductEntity entity){
        ProductDTO dto = new ProductDTO();
        
        dto.setId(entity.getId());
        dto.setProductId(entity.getProductId());
        dto.setCategory(entity.getCategory());
        dto.setExpirationDate(entity.getExpirationDate());
        dto.setPrice(entity.getPrice());
        dto.setMarketId(entity.getMarketId());
        return dto;
    }

    public static ProductEntity convertDTOToEntity(ProductDTO dto){
        ProductEntity entity = new ProductEntity();
        
        entity.setId(dto.getId());
        entity.setProductId(dto.getProductId());
        entity.setCategory(dto.getCategory());
        entity.setExpirationDate(dto.getExpirationDate());
        entity.setPrice(dto.getPrice());
        entity.setMarketId(dto.getMarketId());
        return entity;
    }
}
