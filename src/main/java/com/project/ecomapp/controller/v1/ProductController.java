package com.project.ecomapp.controller.v1;

import com.project.ecomapp.dto.ProductDto;
import com.project.ecomapp.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId) {
        log.debug("--- Starting getProductsByCategoryId() ---");
        List<ProductDto> products = productService.getProductsByCategoryId(categoryId);
        log.debug("--- Ending getProductsByCategoryId() ---");
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
        log.debug("--- Starting getProductById() ---");
        ProductDto productDto = productService.getProductById(id);
        log.debug("--- Ending getProductById() ---");
        return ResponseEntity.ok(productDto);
    }

}