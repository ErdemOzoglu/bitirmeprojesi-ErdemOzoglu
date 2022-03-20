package com.case5.demo.app.kdv.dto;

import com.case5.demo.app.product.enums.ProductType;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class KdvDto {

    private ProductType productType;
    private BigDecimal kdvRate;
}
