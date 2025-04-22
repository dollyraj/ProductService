package dev.dolly.ProductService.client;

import dev.dolly.ProductService.dtos.request.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

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
       // FakeStoreProductDTO response=restTemplate.getForObject(getProductUrl, FakeStoreProductDTO.class);
        //Using the generic method
       FakeStoreProductDTO response=requestForObject(getProductUrl,HttpMethod.GET,null, FakeStoreProductDTO.class);
        return response;
    }

    public FakeStoreProductDTO createObject(FakeStoreProductDTO fakeStoreProductDTO) {
        String url="https://fakestoreapi.com/products";
        FakeStoreProductDTO response=restTemplate.postForObject(url,fakeStoreProductDTO,FakeStoreProductDTO.class);
        return response;
    }

    public FakeStoreProductDTO updateObject(int productId, FakeStoreProductDTO fakeStoreProductDTO) {
        String url="https://fakestoreapi.com/products/"+productId;
        FakeStoreProductDTO response=requestForObject(url,HttpMethod.PUT,fakeStoreProductDTO,FakeStoreProductDTO.class);
        return response;
    }


    //We do not have putForObject in RestTemplate class, we have created this using postForObject changing HttpMethod
//    @Nullable
//    public <T> T putForObject(String url, @Nullable Object request, Class<T> responseType) throws RestClientException {
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
//        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType, restTemplate.getMessageConverters());
//        return (T)restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor);
//    }

    @Nullable
    public <T> T requestForObject(String url,HttpMethod httpMethod, @Nullable Object request, Class<T> responseType) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType, restTemplate.getMessageConverters());
        return (T)restTemplate.execute(url, httpMethod, requestCallback, responseExtractor);
    }


    public Boolean deleteObject(int productId) {
        String url="https://fakestoreapi.com/products/"+productId;
        try{
            requestForObject(url,HttpMethod.DELETE,null, FakeStoreProductDTO.class);
            return true;
        }catch (Exception exception){
            return false;
        }
    }
}
