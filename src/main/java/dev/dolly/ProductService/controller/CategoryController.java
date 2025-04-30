package dev.dolly.ProductService.controller;


import dev.dolly.ProductService.model.Category;
import dev.dolly.ProductService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category savedCategory=categoryService.createCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories=categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id){
        Category category= categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category,@PathVariable("id") int id){
        Category updateCategory=categoryService.updateCategory(category, id);
        return ResponseEntity.ok(updateCategory);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") int id){
        Boolean result=categoryService.deleteProduct(id);
        return  ResponseEntity.ok(result);
    }
}
