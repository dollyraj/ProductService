package dev.dolly.ProductService.service;

import dev.dolly.ProductService.client.FakeStoreClient;
import dev.dolly.ProductService.dtos.request.FakeStoreProductDTO;
import dev.dolly.ProductService.dtos.request.ProductProjection;
import dev.dolly.ProductService.dtos.request.ProductRequestDTO;
import dev.dolly.ProductService.exception.CategoryNotFoundException;
import dev.dolly.ProductService.exception.ProductNotFoundException;
import dev.dolly.ProductService.model.Category;
import dev.dolly.ProductService.model.Product;
import dev.dolly.ProductService.repository.CategoryRepository;
import dev.dolly.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public Product saveProduct(ProductRequestDTO productRequestDTO){
        //check if category exist or not
        Optional<Category> optionalCategory=categoryRepository.findById(productRequestDTO.getCategoryId());
        if(optionalCategory.isEmpty()){
            throw new CategoryNotFoundException("Category not found with id: "+productRequestDTO.getCategoryId());
        }

        Category savedCategory= optionalCategory.get();

        //if category exist, save the product
        Product product=new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setRating(productRequestDTO.getRating());
        product.setQuantity(productRequestDTO.getQuantity());

        Product savedProduct=productRepository.save(product);

        //Add product to category
        savedCategory.getProducts().add(savedProduct);
        //Save the category
        categoryRepository.save(savedCategory);
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

    public Page<Product> getAllProductsPaginated(int pageNumber,String filterAsc,String filterDesc){

        //first create sort object
        //Sort sort=Sort.by("price").ascending().and(Sort.by("rating").descending());
        //To D0---> Implement using sortDTO
        Sort sort=Sort.by(filterAsc).ascending().and(Sort.by(filterDesc).descending());
        return productRepository.findAll(PageRequest.of(pageNumber,3,sort));
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product updateProduct(Product newProduct,int productId){
        Product savedProduct=getProduct(productId);
        newProduct.setId(savedProduct.getId());
        Product updatedProduct=productRepository.save(newProduct);
        return updatedProduct;
    }

    public ProductProjection getProductProjection(String productName){
        return productRepository.findFirstByName(productName);
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

        return productRepository.findAllByDescriptionIgnoreCase(description);
    }

    public Category getCategoryFromProduct(int productId){

        Optional<Product> optionalProduct=productRepository.findById(productId);
        if(optionalProduct.isEmpty())
            throw new ProductNotFoundException("Product not found with id "+productId);

        Product product=optionalProduct.get();
        Optional<Category> optionalCategory=categoryRepository.findByProductsIn(List.of(product));

        if(optionalCategory.isEmpty()){
            throw new CategoryNotFoundException("Category not Found for Product with: "+productId);
        }

        return optionalCategory.get();
    }
}
