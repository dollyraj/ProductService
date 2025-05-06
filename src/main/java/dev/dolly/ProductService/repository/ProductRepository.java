package dev.dolly.ProductService.repository;

import dev.dolly.ProductService.dtos.request.ProductProjection;
import dev.dolly.ProductService.model.Category;
import dev.dolly.ProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByDescription(String description);
    List<Product> findAllByDescriptionIgnoreCase(String description);
    Product findFirstByDescriptionIgnoreCase(String description);

    ProductProjection findFirstByName(String name);

    // Product does not contain category
    //JPA deals at object level not at DB level so it doesn't know category id
    // so it will throw error
    //List<Product> findAllByCategory(Category category);
    //so we will write method in categoryService and will let productService talk to categoryService

}
/*extending JpaRepository adds all fundamental CRUD operation methods in ProductRepository interface
we do no need to implement those methods , Spring Data JPA will do that for us.
we will just use them directly



Templates
findAll
findBy
findFirst
findLast
findAllBy<ATTRIBUTENAME> IgnoreCase
findAllByDescriptionIgnoreCase

Select * from table where <ATTRIBUTENAME>="" IGNORE CASE
 */