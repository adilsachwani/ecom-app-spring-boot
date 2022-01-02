package com.project.ecomapp.mapper;

import com.project.ecomapp.model.Product;
import com.project.ecomapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapperService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(Long id){
        return productRepository.getById(id);
    }

}
