package com.project.ecomapp.mapper;

import com.project.ecomapp.dto.ProductDto;
import com.project.ecomapp.dto.ProductRequestDto;
import com.project.ecomapp.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);

    List<ProductDto> toListDto(List<Product> productList);

}