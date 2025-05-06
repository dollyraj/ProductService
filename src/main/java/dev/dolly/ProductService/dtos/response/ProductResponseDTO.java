package dev.dolly.ProductService.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private String productName;
    private String productDescription;
    private double productPrice;
    private double rating;

}
