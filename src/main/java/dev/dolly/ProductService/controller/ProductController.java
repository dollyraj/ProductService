package dev.dolly.ProductService.controller;

import dev.dolly.ProductService.dtos.request.FakeStoreProductDTO;
import dev.dolly.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public FakeStoreProductDTO[] getAllProducts(){

        return productService.getAllProductsFromFakeStore();

    }

    @GetMapping("/products/{id}")
    public FakeStoreProductDTO getProductById(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @PostMapping("/products")
    public FakeStoreProductDTO createObject(@RequestBody FakeStoreProductDTO fakeStoreProductDTO){
        return productService.createObject(fakeStoreProductDTO);
    }

    @PutMapping("/products/{id}")
    public FakeStoreProductDTO updateObject(@PathVariable("id") int productId,@RequestBody FakeStoreProductDTO fakeStoreProductDTO){
        return productService.updateObject(productId,fakeStoreProductDTO);
    }

    @DeleteMapping("/products/{id}")
    public Boolean deleteObject(@PathVariable("id") int productId){
        return productService.deleteObject(productId);
    }
}
