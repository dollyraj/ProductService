package dev.dolly.ProductService.repository;

import dev.dolly.ProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByDescription(String description);

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