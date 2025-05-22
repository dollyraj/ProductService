package dev.dolly.ProductService.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortDTO {
    private String filterName;
    private String filterType;// assume true-->ascending,false--->descending
}
