package dev.dolly.ProductService.repository;

import dev.dolly.ProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
/*extending JpaRepository adds all fundamental CRUD operation methods in ProductRepository interface
we do no need to implement those methods , Spring Data JPA will do that for us.
we will just use them directly
 */