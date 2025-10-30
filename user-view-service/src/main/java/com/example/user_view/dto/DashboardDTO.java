package com.example.user_view.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class DashboardDTO {

    private List<MarketViewDTO> markets;
    private List<ProductViewDTO> allProducts;
    private Map<String, List<ProductViewDTO>> productsByCategory;
    private List<ProductViewDTO> expiringSoon;
}
