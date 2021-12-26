package com.project.ecomapp.dto;

import com.project.ecomapp.constant.ProductStatus;
import com.project.ecomapp.model.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private ProductStatus status;
    private Long categoryId;

}