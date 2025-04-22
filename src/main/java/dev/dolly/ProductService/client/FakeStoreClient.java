package dev.dolly.ProductService.client;

import dev.dolly.ProductService.dtos.request.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreClient {

    @Autowired
    private RestTemplate restTemplate;

    public FakeStoreProductDTO[] getAllProducts(){

        String getAllProductURL="https://fakestoreapi.com/products";
        FakeStoreProductDTO[] response=restTemplate.getForObject(getAllProductURL,FakeStoreProductDTO[].class);

        return response;

    }

    public FakeStoreProductDTO getProduct(int productId) {
        String getProductUrl="https://fakestoreapi.com/products/"+productId;
        FakeStoreProductDTO response=restTemplate.getForObject(getProductUrl, FakeStoreProductDTO.class);

        return response;
    }
}
