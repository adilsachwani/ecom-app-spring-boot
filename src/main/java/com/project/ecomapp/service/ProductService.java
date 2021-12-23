package com.project.ecomapp.service;

import com.project.ecomapp.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getProductsByCategoryId(Long categoryId) throws Exception;

    ProductDto getProductById(Long id) throws Exception;

}