package com.case5.demo.app.kdv.dto;

import com.case5.demo.app.product.enums.ProductType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class KdvUpdateRequestDto {

    private Long id;
    private ProductType productType;
    private BigDecimal kdvRate;
}
