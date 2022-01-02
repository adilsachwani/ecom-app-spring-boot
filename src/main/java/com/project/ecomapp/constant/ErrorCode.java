package com.project.ecomapp.constant;

import lombok.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Category
    CATEGORY_NOT_FOUND(404, "Category not found", "Category not found with id %s"),
    // Customer
    CUSTOMER_NOT_FOUND(404, "Customer not found", "Customer not found with code %s"),
    CUSTOMER_CONTACT_ALREADY_EXISTS(409, "Contact already exists", "Customer already exists with supplied contact"),
    // Product
    PRODUCT_NOT_FOUND(404, "Product not found", "Product not found with id %s"),
    // Order
    ORDER_NOT_FOUND(404, "Order not found", "Order not found with id %s");

    private Integer code;
    private String message;
    private String detailedMessage;

}