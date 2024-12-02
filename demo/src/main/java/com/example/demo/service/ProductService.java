package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProduct();

    Product getProductById(Long productId);

     void deleteProduct(Long productId);

     Product updateProduct(Product product,Long productId);
}
