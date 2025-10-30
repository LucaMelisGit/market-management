package com.example.user_view.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user_view.dto.MarketViewDTO;

@Service
public class MarketClient {
    
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://market-service:8081/markets";

    public List<MarketViewDTO> getAllMarkets(){
        MarketViewDTO[] markets = restTemplate.getForObject(
            baseUrl,
            MarketViewDTO[].class
        );
        return Arrays.asList(markets);
    }

    public List<MarketViewDTO> getMarketById(Long marketId){
        MarketViewDTO[] markets = restTemplate.getForObject(
            baseUrl + "/id/" + marketId, 
            MarketViewDTO[].class
        );
        return Arrays.asList(markets);
    }
}
