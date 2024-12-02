package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private  CategoryService categoryServic;

    @PostMapping("categories")
    public  Category saveCategory(@RequestBody Category category){
        return categoryServic.saveCategory(category);
    }

    @GetMapping("categories")
    public List<Category> getAllCategory(){
        return categoryServic.getAllCategory();
    }

    @GetMapping("categories/{categoryId}")
    public Category getCategoryById(@PathVariable Long categoryId ){
        return categoryServic.getCategoryById(categoryId);
    }

    @PutMapping("categories/{categoryId}")
    public  Category updateCategory(@PathVariable Long categoryId,@RequestBody Category category){
        return categoryServic.updateCategory(category,categoryId);
    }

    @DeleteMapping("categories/{categoryId}")
    public String deleteCategoryById(@PathVariable Long categoryId ){
        categoryServic.deleteCategory(categoryId);
        return "Category Delete SuccessFully";
    }

}
