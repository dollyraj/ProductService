package dev.dolly.ProductService.controller;

import dev.dolly.ProductService.dtos.request.FakeStoreProductDTO;
import dev.dolly.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
