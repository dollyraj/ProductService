package dev.dolly.ProductService.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

    private String name;
    private String description;
    private int categoryId;
    private double price;
    private double rating;
    private int quantity;
}
