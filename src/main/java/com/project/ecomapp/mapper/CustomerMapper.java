package com.project.ecomapp.mapper;

import com.project.ecomapp.dto.CustomerRequestDto;
import com.project.ecomapp.dto.CustomerResponseDto;
import com.project.ecomapp.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponseDto toResponseDto(Customer customer);

    Customer fromRequestDto(CustomerRequestDto customerRequestDto);

}