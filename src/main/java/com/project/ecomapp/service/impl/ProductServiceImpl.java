package com.project.ecomapp.service.impl;

import com.project.ecomapp.constant.ProductStatus;
import com.project.ecomapp.dto.ProductDto;
import com.project.ecomapp.mapper.ProductMapper;
import com.project.ecomapp.model.Category;
import com.project.ecomapp.model.Product;
import com.project.ecomapp.repository.CategoryRepository;
import com.project.ecomapp.repository.ProductRepository;
import com.project.ecomapp.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> getProductsByCategoryId(Long categoryId) throws Exception {
        log.debug("--- Starting getProductsByCategoryId() ---");
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new Exception("Category not found"));
        List<Product> products = productRepository.findAllByCategoryAndStatus(category, ProductStatus.AVAILABLE);
        log.debug("--- Ending getProductsByCategoryId() ---");
        return productMapper.toListDto(products);
    }

    @Override
    public ProductDto getProductById(Long id) throws Exception {
        log.debug("--- Starting getProductById() ---");
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
        log.debug("--- Ending getProductById() ---");
        return  productMapper.toDto(product);
    }

}