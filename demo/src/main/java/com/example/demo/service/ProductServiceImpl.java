package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

@Autowired
private ProductRepository productRepository;
@Autowired
private CategoryService categoryService;

    @Override
    public Product saveProduct(Product product) {
        Category category = categoryService.getCategoryById(product.getCategory().getId());
        if(category != null) {
            product.setCategory(category);
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product updateProduct(Product product, Long productId) {
        Product oldproduct= getProductById(productId);
        oldproduct.setName(product.getName());
        oldproduct.setPrice(product.getPrice());
        oldproduct.setQuantity(product.getQuantity());
        return productRepository.save(oldproduct);
    }
}
