package dev.dolly.ProductService.dtos.response;

import dev.dolly.ProductService.dtos.request.FakeStoreProductDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreGetAllProductRespDTO {
   private List<FakeStoreProductDTO> fakeStoreProducts;
}
