package dev.dolly.ProductService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity

public class Product extends BaseModel{
//    @Id//this tells that id is primary key
//    @GeneratedValue(strategy = GenerationType.AUTO) // and this tells it is auto generated
//    private int id;
    private String name;
    private String category;
    private double price;
    private String description;
    private double rating;
    private int quantity;

    //relation from product to category is manytoone
//    @ManyToOne
//    private Category category;
    //Audit columns
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//    private String createdBy;
//    private String updatedBy;

}
