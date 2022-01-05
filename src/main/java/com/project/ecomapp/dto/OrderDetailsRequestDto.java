package com.project.ecomapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailsRequestDto {

    @NotNull(message = "product id cannot be null")
    private Long productId;

    @NotNull(message = "quantity cannot be null")
    @Size(min = 1, message = "quantity must be greater than 0")
    private Integer quantity;

}