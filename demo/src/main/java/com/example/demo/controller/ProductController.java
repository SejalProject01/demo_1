package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("products")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("products")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("products/{productId}")
    public Product getProductById(@PathVariable Long productId ){
        return productService.getProductById(productId);
    }

    @PutMapping("products/{productId}")
    public  Product updateProduct(@PathVariable Long productId,@RequestBody Product product){
        return productService.updateProduct(product,productId);
    }

    @DeleteMapping("products/{productId}")
    public String deleteProductById(@PathVariable Long productId ){
        productService.deleteProduct(productId);
        return "Product Delete SuccessFully";
    }

}
