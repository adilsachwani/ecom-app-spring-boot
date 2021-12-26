package com.project.ecomapp.controller.v1;

import com.project.ecomapp.dto.CategoryDto;
import com.project.ecomapp.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products/categories")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        log.debug("--- Starting getAllCategories() ---");
        List<CategoryDto> categories = categoryService.getAllCategories();
        log.debug("--- Ending getAllCategories() ---");
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(name = "id") Long id) {
        log.debug("--- Starting getAllCategories() ---");
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        log.debug("--- Ending getAllCategories() ---");
        return ResponseEntity.ok(categoryDto);
    }

}