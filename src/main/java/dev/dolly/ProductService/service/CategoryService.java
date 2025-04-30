package dev.dolly.ProductService.service;

import dev.dolly.ProductService.model.Category;
import dev.dolly.ProductService.model.Product;
import dev.dolly.ProductService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        Category savedCategory=categoryRepository.save(category);
        return savedCategory;
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(int categoryId){
        Optional<Category> categoryOptional=categoryRepository.findById(categoryId);
        return categoryOptional.get();
    }

    public Category updateCategory(Category newCategory,int categoryId){
        Category category=getCategoryById(categoryId);
        //newCategory.setId(category.id);
        Category updatedCategory=categoryRepository.save(newCategory);
        return updatedCategory;
    }

    public boolean deleteProduct(int productId){
        categoryRepository.deleteById(productId);
        return true;
    }
}
