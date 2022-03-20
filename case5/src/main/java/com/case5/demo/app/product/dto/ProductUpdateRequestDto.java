package com.case5.demo.app.product.dto;

import com.case5.demo.app.product.enums.ProductType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateRequestDto {

    private Long id;
    private String productName;
    private ProductType productType;
    private BigDecimal firstPrice;
}
