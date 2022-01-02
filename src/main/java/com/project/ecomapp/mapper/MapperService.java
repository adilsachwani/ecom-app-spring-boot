package com.project.ecomapp.mapper;

import com.project.ecomapp.model.Customer;
import com.project.ecomapp.model.Product;
import com.project.ecomapp.repository.CustomerRepository;
import com.project.ecomapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapperService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public Customer getCustomerById(Long id){
        return customerRepository.getById(id);
    }

    public Product getProductById(Long id){
        return productRepository.getById(id);
    }

}
