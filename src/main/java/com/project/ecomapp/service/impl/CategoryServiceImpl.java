package com.project.ecomapp.service.impl;

import com.project.ecomapp.dto.CategoryDto;
import com.project.ecomapp.exception.ServiceException;
import com.project.ecomapp.mapper.CategoryMapper;
import com.project.ecomapp.model.Category;
import com.project.ecomapp.repository.CategoryRepository;
import com.project.ecomapp.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.ecomapp.constant.ErrorCode.NOT_FOUND;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        log.debug("--- Starting getAllCategories() ---");
        List<Category> categories = categoryRepository.findAll();
        log.debug("--- Ending getAllCategories() ---");
        return categoryMapper.toListDto(categories);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        log.debug("--- Starting getCategoryById() ---");
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ServiceException(NOT_FOUND.getCode(), NOT_FOUND.getMessage(),
                        String.format(NOT_FOUND.getDetailedMessage(), "Category Id: " + id)));
        log.debug("--- Ending getCategoryById() ---");
        return categoryMapper.toDto(category);
    }

}