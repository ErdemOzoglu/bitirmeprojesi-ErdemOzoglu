package com.case5.demo.app.product.dto;

import com.case5.demo.app.product.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    private String productName;
    private ProductType productType;
    private BigDecimal firstPrice;
    private BigDecimal lastPrice;
    private BigDecimal kdvRate;

}
