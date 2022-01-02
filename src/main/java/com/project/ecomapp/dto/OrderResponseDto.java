package com.project.ecomapp.dto;

import com.project.ecomapp.constant.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDto {

    private Long id;
    private OrderStatus status;
    private Long customerId;
    private List<OrderDetailsResponseDto> details;

}