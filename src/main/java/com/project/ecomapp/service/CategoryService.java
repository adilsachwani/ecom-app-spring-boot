package com.project.ecomapp.service;

import com.project.ecomapp.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryById(Long id) throws Exception;

}