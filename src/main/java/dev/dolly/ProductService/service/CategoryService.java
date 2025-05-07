package dev.dolly.ProductService.service;

import dev.dolly.ProductService.dtos.request.CategoryRequestDTO;
import dev.dolly.ProductService.exception.CategoryNotFoundException;
import dev.dolly.ProductService.exception.DuplicateCategoryNameException;
import dev.dolly.ProductService.exception.ProductNotFoundException;
import dev.dolly.ProductService.model.Category;
import dev.dolly.ProductService.model.Product;
import dev.dolly.ProductService.repository.CategoryRepository;
import dev.dolly.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

   /* @Autowired
    private ProductService productService;
    ---->caused circular dependency
    */

    public Category createCategory(CategoryRequestDTO categoryRequestDTO) {
        Optional<Category> categoryOptional=categoryRepository.findByName(categoryRequestDTO.getCategoryName());
        if(!categoryOptional.isEmpty()){
            throw new DuplicateCategoryNameException("Duplicate category name "+categoryRequestDTO.getCategoryName());
        }
        Category category=new Category();
        category.setName(categoryRequestDTO.getCategoryName());
        category.setDescription(categoryRequestDTO.getCategoryDescription());
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){

        return categoryRepository.findAll();
    }

    public Category getCategoryById(int categoryId){
        Optional<Category> categoryOptional=categoryRepository.findById(categoryId);
        if(categoryOptional.isEmpty())
            throw new CategoryNotFoundException("Category Not Found with Id: "+ categoryId);
        return categoryOptional.get();
    }

    public Category updateCategory(CategoryRequestDTO newCategory,int categoryId){
        Category savedCategory=getCategoryById(categoryId);
        savedCategory.setName(newCategory.getCategoryName());
        savedCategory.setDescription(newCategory.getCategoryDescription());
        Category updatedCategory=categoryRepository.save(savedCategory);
        return updatedCategory;
    }

    public boolean deleteProduct(int productId){
        categoryRepository.deleteById(productId);
        return true;
    }

    public List<Product> getAllProductsByCategory(int categoryId){
        Category savedCategory=getCategoryById(categoryId);
        System.out.println(savedCategory.getName());
        List<Product> products=savedCategory.getProducts();
        System.out.println(products.size());
        return products;
    }

    /* getting circular dependency error
    ┌─────┐
            |  categoryService (field private dev.dolly.ProductService.service.ProductService dev.dolly.ProductService.service.CategoryService.productService)
↑     ↓
        |  productService (field dev.dolly.ProductService.service.CategoryService dev.dolly.ProductService.service.ProductService.categoryService)
└─────┘

     */


    public Category getCategoryFromProduct(int productId){
        Optional<Product>  productOptional= productRepository.findById(productId);
        if(productOptional.isEmpty())
            throw new ProductNotFoundException("Product not found with id: "+productId);


        Optional<Category> optionalCategory=categoryRepository.findByProductsIn(List.of(productOptional.get()));

        if(optionalCategory.isEmpty()){
            throw new CategoryNotFoundException("Category not Found for Product with: "+productId);
        }

        return optionalCategory.get();
    }
}
