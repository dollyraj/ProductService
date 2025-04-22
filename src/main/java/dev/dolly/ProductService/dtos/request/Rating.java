package dev.dolly.ProductService.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating {
    private double rate;
    private int count;
}
