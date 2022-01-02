package com.project.ecomapp.service;

import com.project.ecomapp.dto.OrderRequestDto;
import com.project.ecomapp.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {

    OrderResponseDto getOrderByOrderId(Long orderId);

    List<OrderResponseDto> getOrdersByCustomerCode(String customerCode);

    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);

}