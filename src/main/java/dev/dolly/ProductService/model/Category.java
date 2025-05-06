package dev.dolly.ProductService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModel {

    //relation from category to product is onetomany
    @OneToMany(fetch =FetchType.EAGER)
    @JoinColumn(name="category_id")
    private List<Product> products;
    private String name;
    private String description;
}
