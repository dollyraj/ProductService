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

//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private int id;
    private String name;
    private String description;
    //relation from category to product is onetomany
    @OneToMany(fetch =FetchType.EAGER)
    @JoinColumn(name="category_id")
    private List<Product> products;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//    private String createdBy;
//    private String updatedBy;
}
