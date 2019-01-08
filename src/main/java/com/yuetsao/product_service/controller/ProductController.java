package com.yuetsao.product_service.controller;

import com.yuetsao.product_service.domain.Product;
import com.yuetsao.product_service.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @Value("${env}")
    private String env;

    @Autowired
    private ProductService productService;

    @RequestMapping("list")
    public Object getList() {
        return productService.listProduct();
    }

    @RequestMapping("findById")
    public Object findById(@RequestParam("id") int id) {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Product product = productService.findById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product, result);
        result.setName(product.getName()+"data from" + port+ "env=" + env);
        return result;
    }
}
