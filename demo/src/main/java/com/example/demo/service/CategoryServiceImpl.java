package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

@Autowired
private CategoryRepository categoryRepository;
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + categoryId));

    }

    @Override
    public void deleteCategory(Long categoryId) {
         categoryRepository.deleteById(categoryId);

    }

    @Override
    public Category updateCategory(Category category,Long categoryId) {
        Category oldcategory=  getCategoryById(categoryId);
        oldcategory.setCategoryname( category.getCategoryname());
        return categoryRepository.save(oldcategory) ;
    }

//    private CategoryDTO convertToDTO(Category category) {
//        CategoryDTO dto = new CategoryDTO();
//        dto.setId(category.getId());
//        dto.setCategoryname(category.getCategoryname());
//        dto.setProducts(
//                category.getProducts()
//                        .stream()
//                        .map(product -> {
//                            ProductDTO productDTO = new ProductDTO();
//                            productDTO.setId(product.());
//                            productDTO.setName(product.getName());
//                            productDTO.setPrice(product.getPrice());
//                            productDTO.setQuantity(product.getQuantity());
//                            productDTO.setCategoryId(category.getId());
//                            return productDTO;
//                        })
//                        .collect(Collectors.toList())
//        );
//        return dto;
//    }
}
