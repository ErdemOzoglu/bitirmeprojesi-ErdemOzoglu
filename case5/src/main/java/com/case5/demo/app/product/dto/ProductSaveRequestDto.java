package com.case5.demo.app.product.dto;

import com.case5.demo.app.product.enums.ProductType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductSaveRequestDto {

    private String productName;
    private ProductType productType;
    private BigDecimal firstPrice;
}
