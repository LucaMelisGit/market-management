package com.example.user_view.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_view.client.MarketClient;
import com.example.user_view.client.ProductClient;
import com.example.user_view.dto.DashboardDTO;
import com.example.user_view.dto.MarketViewDTO;
import com.example.user_view.dto.ProductViewDTO;
import com.example.user_view.service.UserViewService;

@Service
public class UserViewServiceImpl extends UserViewService {
    
    @Autowired
    private MarketClient marketClient;

    @Autowired
    private ProductClient productClient;

    @Override
    public DashboardDTO getDashboardDTO(){
        DashboardDTO dashboard = new DashboardDTO();

        List<MarketViewDTO> markets = marketClient.getAllMarkets();

        //filtro prodotti del market totali
        List<ProductViewDTO> allProductsByMarketId = markets.stream()
        .flatMap(market -> {
            List<ProductViewDTO> marketProducts = productClient.getProductsByMarketId(market.getId());

            marketProducts.forEach(p -> p.setMarketName(market.getName()));
            return marketProducts.stream();
        }).collect(Collectors.toList());

        //filtro scadenze ultimi 7 giorni
        List<ProductViewDTO> expiringSoon = allProductsByMarketId.stream()
        .filter(p -> p.getExpirationDate() != null)
        .filter(p -> p.getExpirationDate().isBefore(LocalDate.now().plusDays(7)))
        .collect(Collectors.toList());

        //filtro prodotti per categoria
        Map<String, List<ProductViewDTO>> productsByCategory = allProductsByMarketId.stream()
        .collect(Collectors.groupingBy(ProductViewDTO::getCategory));

        //assegna i dati alla dashboard
        dashboard.setAllProducts(allProductsByMarketId);
        dashboard.setExpiringSoon(expiringSoon);
        dashboard.setMarkets(markets);
        dashboard.setProductsByCategory(productsByCategory);

        return dashboard;
    }
}
