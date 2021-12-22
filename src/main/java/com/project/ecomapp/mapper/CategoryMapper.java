package com.project.ecomapp.mapper;

import com.project.ecomapp.dto.CategoryDto;
import com.project.ecomapp.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category category);

    List<CategoryDto> toListDto(List<Category> categoryList);

}