package com.example.product.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.dto.ProductDTO;
import com.example.product.mapper.ProductMapper;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;

@Service
public class ProductServiceImpl extends ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAllByMarketId(Long marketId){
        return productRepository.findAll().stream().filter(product -> product.getMarketId().equals(marketId)).map(ProductMapper::convertEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllByMarketIdAndCategory(Long marketId, String category){
        return productRepository.findAll().stream().filter(product -> product.getCategory().equals(category) && product.getMarketId().equals(marketId)).map(ProductMapper::convertEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllByMarketIdAndExpitationDate(Long marketId, LocalDate expirationDate){
        return productRepository.findAll().stream().filter(product -> product.getExpirationDate().equals(expirationDate) && product.getMarketId().equals(marketId)).map(ProductMapper::convertEntityToDTO).collect(Collectors.toList());
    }
}
