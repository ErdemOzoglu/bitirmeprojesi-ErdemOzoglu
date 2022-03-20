package com.case5.demo.app.product.entity;

import com.case5.demo.app.gen.entity.BaseEntity;
import com.case5.demo.app.product.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTED")
@Getter
@Setter
public class Product extends BaseEntity {


    @Id
    @SequenceGenerator(name = "Product" , sequenceName = "PRODUCTED_ID_SEQ")
    @GeneratedValue(generator = "Product")
    private Long id;

    @Column(name ="PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "PRODUCT_TYPE",nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Min(1)
    @Column(name = "FIRST_PRICE",nullable = false)
    private BigDecimal firstPrice;

    @Min(1)
    @Column(name = "LAST_PRICE")
    private BigDecimal lastPrice;

    @Min(0)
    @Column(name = "KDV_RATE")
    private BigDecimal kdvRate;



}
