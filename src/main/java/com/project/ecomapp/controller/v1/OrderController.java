package com.project.ecomapp.controller.v1;

import com.project.ecomapp.dto.OrderRequestDto;
import com.project.ecomapp.dto.OrderResponseDto;
import com.project.ecomapp.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOrderByOrderId(@PathVariable("id") Long id){
        log.debug("--- Starting getOrderByOrderId() ---");
        OrderResponseDto orderResponseDto = orderService.getOrderByOrderId(id);
        log.debug("--- Ending getOrderByOrderId() ---");
        return ResponseEntity.ok(orderResponseDto);
    }

    @GetMapping("/customer/{customerCode}")
    public ResponseEntity<List<OrderResponseDto>> getOrdersByCustomerCode(@PathVariable("customerCode") String customerCode){
        log.debug("--- Starting getOrdersByCustomerCode() ---");
        List<OrderResponseDto> orderResponseDtoList = orderService.getOrdersByCustomerCode(customerCode);
        log.debug("--- Ending getOrdersByCustomerCode() ---");
        return ResponseEntity.ok(orderResponseDtoList);
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto){
        log.debug("--- Starting createOrder() ---");
        OrderResponseDto orderResponseDto = orderService.createOrder(orderRequestDto);
        log.debug("--- Ending createOrder() ---");
        return ResponseEntity.ok(orderResponseDto);
    }

}