package dev.dolly.ProductService.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDTO {
    private String message;
    private Integer status;
}
