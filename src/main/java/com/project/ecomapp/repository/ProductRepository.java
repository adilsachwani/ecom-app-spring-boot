package com.project.ecomapp.repository;

import com.project.ecomapp.constant.ProductStatus;
import com.project.ecomapp.model.Category;
import com.project.ecomapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategoryAndStatus(Category category, ProductStatus status);

}