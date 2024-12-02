package com.example.demo.service;

import com.example.demo.entity.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(Category category);

    List<Category> getAllCategory();

    Category getCategoryById(Long categoryId);

     void deleteCategory(Long categoryId);

     Category updateCategory(Category category,Long categoryId);
}
