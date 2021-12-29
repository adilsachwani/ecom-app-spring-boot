package com.project.ecomapp.controller.v1;

import com.project.ecomapp.dto.CustomerRequestDto;
import com.project.ecomapp.dto.CustomerResponseDto;
import com.project.ecomapp.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/customers")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerCode}")
    public ResponseEntity<CustomerResponseDto> getCustomerByCustomerCode(@PathVariable(name = "customerCode") String customerCode){
        log.debug("--- Starting getCustomerByCustomerCode() ---");
        CustomerResponseDto customerResponseDto = customerService.getCustomerByCustomerCode(customerCode);
        log.debug("--- Starting getCustomerByCustomerCode() ---");
        return ResponseEntity.ok(customerResponseDto);
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> getCustomerByCustomerCode(@RequestBody CustomerRequestDto customerRequestDto){
        log.debug("--- Starting registerCustomer() ---");
        CustomerResponseDto customerResponseDto = customerService.registerCustomer(customerRequestDto);
        log.debug("--- Starting registerCustomer() ---");
        return ResponseEntity.ok(customerResponseDto);
    }

}