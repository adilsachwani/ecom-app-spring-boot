package com.project.ecomapp.service.impl;

import com.project.ecomapp.dto.OrderRequestDto;
import com.project.ecomapp.dto.OrderResponseDto;
import com.project.ecomapp.exception.ServiceException;
import com.project.ecomapp.mapper.OrderMapper;
import com.project.ecomapp.model.Order;
import com.project.ecomapp.repository.CustomerRepository;
import com.project.ecomapp.repository.OrderRepository;
import com.project.ecomapp.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.project.ecomapp.constant.ErrorCode.CUSTOMER_NOT_FOUND;
import static com.project.ecomapp.constant.ErrorCode.ORDER_NOT_FOUND;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public OrderResponseDto getOrderByOrderId(Long orderId) {
        log.debug("--- Starting getOrderByOrderId() ---");
        Order order = orderRepository.findById(orderId)
                        .orElseThrow(() -> new ServiceException(ORDER_NOT_FOUND.getCode(), ORDER_NOT_FOUND.getMessage(),
                                String.format(ORDER_NOT_FOUND.getDetailedMessage(), orderId)));
        log.debug("--- Ending getOrderByOrderId() ---");
        return orderMapper.toResponseDto(order);
    }

    @Override
    public List<OrderResponseDto> getOrdersByCustomerCode(String customerCode) {
        log.debug("--- Starting getOrdersByCustomerCode() ---");
        if(!customerRepository.existsByCustomerCode(customerCode)) {
            throw new ServiceException(CUSTOMER_NOT_FOUND.getCode(), CUSTOMER_NOT_FOUND.getMessage(),
                    String.format(CUSTOMER_NOT_FOUND.getDetailedMessage(), customerCode));
        }
        List<Order> orders = orderRepository.findAllByCustomerCustomerCode(customerCode);
        log.debug("--- Ending getOrdersByCustomerCode() ---");
        return orderMapper.toListResponseDto(orders);
    }

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        log.debug("--- Starting createOrder() ---");
        Order order = orderMapper.fromRequestDto(orderRequestDto);
        if(Objects.nonNull(order.getDetails())){
            order.getDetails().forEach(detail -> detail.setOrder(order));
        }
        Order savedOrder = orderRepository.save(order);
        log.debug("--- Ending createOrder() ---");
        return orderMapper.toResponseDto(savedOrder);
    }

}