package dev.dolly.ProductService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String name;
    private double price;
    private String description;
    private double rating;
    private int quantity;

}
