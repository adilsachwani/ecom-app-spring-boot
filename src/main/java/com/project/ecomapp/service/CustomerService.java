package com.project.ecomapp.service;

import com.project.ecomapp.dto.CustomerRequestDto;
import com.project.ecomapp.dto.CustomerResponseDto;

public interface CustomerService {

     CustomerResponseDto getCustomerByCustomerCode(String customerCode);

     CustomerResponseDto registerCustomer(CustomerRequestDto customerRequestDto);

}