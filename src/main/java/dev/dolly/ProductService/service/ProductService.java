package dev.dolly.ProductService.service;

import dev.dolly.ProductService.client.FakeStoreClient;
import dev.dolly.ProductService.dtos.request.FakeStoreProductDTO;
import dev.dolly.ProductService.exception.ProductNotFoundException;
import dev.dolly.ProductService.model.Product;
import dev.dolly.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){

        Product savedProduct=productRepository.save(product);
        return savedProduct;
    }

    public boolean deleteProduct(int productId){
       productRepository.deleteById(productId);
       return true;
    }

    public Product getProduct(int productId){
        Optional<Product> productOptional=productRepository.findById(productId);

        if(productOptional.isEmpty()){
           throw new ProductNotFoundException("Product with id "+productId+" is not found" );
        }else {
            return productOptional.get();
        }

    }

    public List<Product> getAllProducts(){
     return productRepository.findAll();
    }

    public Product updateProduct(Product newProduct, int productId){
        Product savedProduct = getProduct(productId);
       // newProduct.setId(productId);
        Product updatedProduct = productRepository.save(newProduct);
        return updatedProduct;
    }

     public FakeStoreProductDTO[] getAllProductsFromFakeStore(){
         return fakeStoreClient.getAllProducts();
     }

    public FakeStoreProductDTO getFakeStoreProduct(int productId) {
         return fakeStoreClient.getProduct(productId);
    }

    public FakeStoreProductDTO createObject(FakeStoreProductDTO fakeStoreProductDTO) {
         return fakeStoreClient.createObject(fakeStoreProductDTO);
    }

    public FakeStoreProductDTO updateObject(int productId, FakeStoreProductDTO fakeStoreProductDTO) {
         return fakeStoreClient.updateObject(productId,fakeStoreProductDTO);
    }

    public Boolean deleteObject(int productId) {
         return fakeStoreClient.deleteObject(productId);
    }

    public  List<Product> matchedProducts(String description){

        return productRepository.findAllByDescription(description);
    }
}
