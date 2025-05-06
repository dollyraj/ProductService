package dev.dolly.ProductService.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDTO {
    private String categoryName;
    private String categoryDescription;
}
