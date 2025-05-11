package dev.dolly.ProductService.controller;


import dev.dolly.ProductService.dtos.request.CategoryRequestDTO;
import dev.dolly.ProductService.dtos.response.CategoryResponseDTO;
import dev.dolly.ProductService.dtos.response.ProductResponseDTO;
import dev.dolly.ProductService.model.Category;
import dev.dolly.ProductService.model.Product;
import dev.dolly.ProductService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO){
        Category savedCategory=categoryService.createCategory(categoryRequestDTO);
        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName(savedCategory.getName());
        categoryResponseDTO.setCategoryDescription(savedCategory.getDescription());
        return ResponseEntity.ok(categoryResponseDTO);
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories(){
        List<Category> categories=categoryService.getAllCategories();
        List<CategoryResponseDTO> categoryResponseDTOS=new ArrayList<>();

        for(Category category:categories){
            CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
            categoryResponseDTO.setCategoryName(category.getName());
            categoryResponseDTO.setCategoryDescription(category.getDescription());
            categoryResponseDTOS.add(categoryResponseDTO);
        }
        return ResponseEntity.ok(categoryResponseDTOS);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id") int id){
        Category savedCategory= categoryService.getCategoryById(id);
        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName(savedCategory.getName());
        categoryResponseDTO.setCategoryDescription(savedCategory.getDescription());
        return ResponseEntity.ok(categoryResponseDTO);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@RequestBody CategoryRequestDTO categoryRequestDTO,@PathVariable("id") int id){

        Category updateCategory=categoryService.updateCategory(categoryRequestDTO, id);
        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName(updateCategory.getName());
        categoryResponseDTO.setCategoryDescription(updateCategory.getDescription());
        return ResponseEntity.ok(categoryResponseDTO);
    }



    @DeleteMapping("/category/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") int id){
        Boolean result=categoryService.deleteCategory(id);
        return  ResponseEntity.ok(result);
    }

    @GetMapping("/product/category/{id}")
    public ResponseEntity<List<ProductResponseDTO>> getAllProductsByCategory(@PathVariable("id") int categoryId){
        List<Product> savedProducts=categoryService.getAllProductsByCategory(categoryId);
        List<ProductResponseDTO> productResponseDTOS=new ArrayList<>();
        for(Product product:savedProducts){
            System.out.println(product);
            ProductResponseDTO productResponseDTO=new ProductResponseDTO();
            productResponseDTO.setProductName(product.getName());
            productResponseDTO.setProductDescription(product.getDescription());
            productResponseDTO.setProductPrice(product.getPrice());
            productResponseDTO.setRating(product.getRating());
            productResponseDTOS.add(productResponseDTO);
        }

        return ResponseEntity.ok(productResponseDTOS);
    }

}
