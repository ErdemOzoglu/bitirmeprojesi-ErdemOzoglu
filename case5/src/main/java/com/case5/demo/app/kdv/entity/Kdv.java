package com.case5.demo.app.kdv.entity;

import com.case5.demo.app.gen.entity.BaseEntity;
import com.case5.demo.app.product.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Entity
@Table(name = "KDV")
@Getter
@Setter
public class Kdv  {

    @Id
    @SequenceGenerator(name = "Kdv" , sequenceName = "KDV_ID_SEQ")
    @GeneratedValue(generator = "Kdv")
    private Long id;

    //@Id
    @Column(name = "PRODUCT_TYPE", unique = true)
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Min(0)
    @Column(name = "KDV_RATE")
    private BigDecimal kdvRate;
}
