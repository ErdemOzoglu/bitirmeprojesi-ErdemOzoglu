package com.case5.demo.app.product.dto;

import com.case5.demo.app.product.enums.ProductType;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class ProductDetailDto {

    private  ProductType productType;
    private  BigDecimal kdvRate;
    private  BigDecimal minPrice;
    private  BigDecimal maxPrice;
    private  double averagePrice;
    private  long numberOfProduct;


}
