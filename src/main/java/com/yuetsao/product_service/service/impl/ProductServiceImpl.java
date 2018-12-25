package com.yuetsao.product_service.service.impl;

import com.yuetsao.product_service.domain.Product;
import com.yuetsao.product_service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Map<Integer, Product> daoMap = new HashMap<Integer, Product>();

    static{
        Product product = new Product(1, "iphoneX", 9999, 103);
        Product product1 = new Product(2, "冰箱", 233, 104);
        Product product2 = new Product(3, "洗衣机", 534, 105);
        Product product3 = new Product(4, "电话", 345, 105);
        Product product4 = new Product(5, "汽车", 4645, 140);
        Product product5 = new Product(6, "椅子", 342, 150);
        Product product6 = new Product(7, "Java 编程思想", 23, 150);

        daoMap.put(product.getId(),product);
        daoMap.put(product1.getId(),product1);
        daoMap.put(product2.getId(),product2);
        daoMap.put(product3.getId(),product3);
        daoMap.put(product4.getId(),product4);
        daoMap.put(product5.getId(),product5);
        daoMap.put(product6.getId(),product6);
    }
    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = daoMap.values();
        List<Product> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public Product findById(int id) {
        return daoMap.get(id);
    }
}
