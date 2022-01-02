package com.project.ecomapp.mapper;

import com.project.ecomapp.dto.OrderDetailsRequestDto;
import com.project.ecomapp.dto.OrderDetailsResponseDto;
import com.project.ecomapp.dto.OrderRequestDto;
import com.project.ecomapp.dto.OrderResponseDto;
import com.project.ecomapp.model.Order;
import com.project.ecomapp.model.OrderDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = MapperService.class)
public interface OrderMapper {

    @Mapping(source = "customerId", target = "customer")
    Order fromRequestDto(OrderRequestDto orderRequestDto);

    @Mapping(source = "customer.id", target = "customerId")
    OrderResponseDto toResponseDto(Order order);

    List<OrderResponseDto> toListResponseDto(List<Order> orders);

    @Mapping(source = "productId", target = "product")
    OrderDetails fromRequestDto(OrderDetailsRequestDto orderDetailsRequestDto);

    @Mapping(source = "product.category.id", target = "product.categoryId")
    OrderDetailsResponseDto toResponseDto(OrderDetails orderDetails);

}