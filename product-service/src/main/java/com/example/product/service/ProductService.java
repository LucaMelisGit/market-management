package com.example.product.service;

import java.time.LocalDate;
import java.util.List;

import com.example.product.dto.ProductDTO;

public abstract class ProductService {

    public abstract List<ProductDTO> findAllByMarketId(Long marketId);

    public abstract List<ProductDTO> getAllByMarketIdAndCategory(Long marketId, String category);

    public abstract List<ProductDTO> getAllByMarketIdAndExpitationDate(Long marketId, LocalDate expirationDate);
}
