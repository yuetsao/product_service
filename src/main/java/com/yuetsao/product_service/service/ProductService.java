package com.yuetsao.product_service.service;

import com.yuetsao.product_service.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProduct();
    Product findById(int id);

}
