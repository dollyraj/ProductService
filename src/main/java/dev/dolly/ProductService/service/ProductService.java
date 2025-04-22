package dev.dolly.ProductService.service;

import dev.dolly.ProductService.client.FakeStoreClient;
import dev.dolly.ProductService.dtos.request.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private FakeStoreClient fakeStoreClient;
     public FakeStoreProductDTO[] getAllProductsFromFakeStore(){
         return fakeStoreClient.getAllProducts();
     }

    public FakeStoreProductDTO getProduct(int productId) {
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
}
