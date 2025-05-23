package dev.dolly.ProductService.controller;

import dev.dolly.ProductService.dtos.request.FakeStoreProductDTO;
import dev.dolly.ProductService.dtos.request.ProductProjection;
import dev.dolly.ProductService.dtos.request.ProductRequestDTO;
import dev.dolly.ProductService.dtos.response.CategoryResponseDTO;
import dev.dolly.ProductService.dtos.response.ProductResponseDTO;
import dev.dolly.ProductService.model.Category;
import dev.dolly.ProductService.model.Product;
import dev.dolly.ProductService.service.CategoryService;
import dev.dolly.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        Product savedProduct=productService.saveProduct(productRequestDTO);
        return ResponseEntity.ok(savedProduct);

    }

    @PostMapping("/product/create/{n}")
    public ResponseEntity<Boolean> createNProducts(@PathVariable("n") Integer n){
        return ResponseEntity.ok(productService.createNProducts(n));
    }

    @GetMapping("/all/product/{pageNumber}/{filterAsc}/{filterDesc}")
    public ResponseEntity<Page<Product>> getAllProductsPaginated(@PathVariable("pageNumber")int pageNumber,@PathVariable("filterAsc") String filterAsc,@PathVariable("filterDesc") String filterDesc){
        Page<Product> products = productService.getAllProductsPaginated(pageNumber,filterAsc,filterDesc);
        return ResponseEntity.ok(products);
    }
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        Product savedProduct = productService.getProduct(id);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/product/desc/{description}")
    public ResponseEntity<List<Product>> getProductById(@PathVariable("description") String description){
        List<Product> matchedProducts = productService.matchedProducts(description);
        return ResponseEntity.ok(matchedProducts);
    }

    @GetMapping("/product/projection/{name}")
    public ResponseEntity<ProductProjection> getProductProjectionByName(@PathVariable("name") String name){
        ProductProjection productProjection = productService.getProductProjection(name);
        return ResponseEntity.ok(productProjection);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable("id") int productId){
        boolean response = productService.deleteProduct(productId);
        return ResponseEntity.ok(response);
    }

    //update product
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProductById(@RequestBody Product newProduct,@PathVariable("id") int productId){
        Product savedProduct=productService.updateProduct(newProduct,productId);
        return ResponseEntity.ok(savedProduct);
    }

    //getCategoryFromProduct
    @GetMapping("/category/product/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryFromProduct(@PathVariable("id") int productId){
        Category category=productService.getCategoryFromProduct(productId);

        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName(category.getName());
        categoryResponseDTO.setCategoryDescription(category.getDescription());

        return ResponseEntity.ok(categoryResponseDTO);
    }

    @GetMapping("/products/fake")
    public FakeStoreProductDTO[] getAllFakeProducts(){

        return productService.getAllProductsFromFakeStore();

    }

    @GetMapping("/products/fake/{id}")
    public FakeStoreProductDTO getFakeProductById(@PathVariable("id") int productId){
        return productService.getFakeStoreProduct(productId);
    }

    @PostMapping("/products/fake")
    public FakeStoreProductDTO createObject(@RequestBody FakeStoreProductDTO fakeStoreProductDTO){
        return productService.createObject(fakeStoreProductDTO);
    }

    @PutMapping("/products/fake/{id}")
    public FakeStoreProductDTO updateObject(@PathVariable("id") int productId,@RequestBody FakeStoreProductDTO fakeStoreProductDTO){
        return productService.updateObject(productId,fakeStoreProductDTO);
    }

    @DeleteMapping("/products/{id}")
    public Boolean deleteObject(@PathVariable("id") int productId){
        return productService.deleteObject(productId);
    }
}
