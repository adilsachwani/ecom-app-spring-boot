package com.project.ecomapp.service.impl;

import com.project.ecomapp.dto.CustomerRequestDto;
import com.project.ecomapp.dto.CustomerResponseDto;
import com.project.ecomapp.exception.ServiceException;
import com.project.ecomapp.mapper.CustomerMapper;
import com.project.ecomapp.model.Customer;
import com.project.ecomapp.repository.CustomerRepository;
import com.project.ecomapp.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

import static com.project.ecomapp.constant.ErrorCode.CUSTOMER_CONTACT_ALREADY_EXISTS;
import static com.project.ecomapp.constant.ErrorCode.CUSTOMER_NOT_FOUND;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerResponseDto getCustomerByCustomerCode(String customerCode) {
        log.debug("--- Starting getCustomerByCustomerCode() ---");
        Customer customer = customerRepository.findByCustomerCode(customerCode)
                .orElseThrow(() -> new ServiceException(CUSTOMER_NOT_FOUND.getCode(), CUSTOMER_NOT_FOUND.getMessage(),
                        String.format(CUSTOMER_NOT_FOUND.getDetailedMessage(), customerCode)));
        log.debug("--- Starting getCustomerByCustomerCode() ---");
        return customerMapper.toResponseDto(customer);
    }

    @Override
    public CustomerResponseDto registerCustomer(CustomerRequestDto customerRequestDto) {
        log.debug("--- Starting registerCustomer() ---");
       if(customerRepository.existsByContact(customerRequestDto.getContact())){
           throw new ServiceException(CUSTOMER_CONTACT_ALREADY_EXISTS.getCode(), CUSTOMER_CONTACT_ALREADY_EXISTS.getMessage(),
                   CUSTOMER_CONTACT_ALREADY_EXISTS.getDetailedMessage());
       }
        Customer customer = customerMapper.fromRequestDto(customerRequestDto);
        customer.setCustomerCode(UUID.randomUUID().toString());
        if(Objects.nonNull(customer.getAddresses())){
            customer.getAddresses().forEach(address -> address.setCustomer(customer));
        }
        Customer savedCustomer = customerRepository.save(customer);
        log.debug("--- Starting registerCustomer() ---");
        return customerMapper.toResponseDto(savedCustomer);
    }

}