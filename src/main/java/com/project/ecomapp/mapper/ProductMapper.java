package com.project.ecomapp.mapper;

import com.project.ecomapp.dto.ProductDto;
import com.project.ecomapp.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);

    List<ProductDto> toListDto(List<Product> productList);

}