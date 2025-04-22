package dev.dolly.ProductService.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private int id;
    private String title;
    private double price;
    private String description;
    private String image;
    private Rating rating;
}
