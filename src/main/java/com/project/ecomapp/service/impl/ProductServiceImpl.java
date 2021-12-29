package com.project.ecomapp.service.impl;

import com.project.ecomapp.constant.ProductStatus;
import com.project.ecomapp.dto.ProductDto;
import com.project.ecomapp.exception.ServiceException;
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

import static com.project.ecomapp.constant.ErrorCode.CATEGORY_NOT_FOUND;
import static com.project.ecomapp.constant.ErrorCode.PRODUCT_NOT_FOUND;

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
    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        log.debug("--- Starting getProductsByCategoryId() ---");
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ServiceException(CATEGORY_NOT_FOUND.getCode(), CATEGORY_NOT_FOUND.getMessage(),
                        String.format(CATEGORY_NOT_FOUND.getDetailedMessage(), categoryId)));
        List<Product> products = productRepository.findAllByCategoryAndStatus(category, ProductStatus.AVAILABLE);
        log.debug("--- Ending getProductsByCategoryId() ---");
        return productMapper.toListDto(products);
    }

    @Override
    public ProductDto getProductById(Long id) {
        log.debug("--- Starting getProductById() ---");
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ServiceException(PRODUCT_NOT_FOUND.getCode(), PRODUCT_NOT_FOUND.getMessage(),
                        String.format(PRODUCT_NOT_FOUND.getDetailedMessage(), id)));
        log.debug("--- Ending getProductById() ---");
        return  productMapper.toDto(product);
    }

}