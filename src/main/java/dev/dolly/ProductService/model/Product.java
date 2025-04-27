package dev.dolly.ProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Product {
    @Id//this tells that id is primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // and this tells it is auto generated
    private int id;
    private String name;
    private String category;
    private double price;
    private String description;
    private double rating;
    private int quantity;

}
