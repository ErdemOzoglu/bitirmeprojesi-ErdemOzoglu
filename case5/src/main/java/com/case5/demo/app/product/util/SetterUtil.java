package com.case5.demo.app.product.util;

import com.case5.demo.app.kdv.dao.KdvDao;
import com.case5.demo.app.kdv.entity.Kdv;
import com.case5.demo.app.product.entity.Product;
import com.case5.demo.app.product.enums.ProductType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class SetterUtil {

    private final KdvDao kdvDao;

    public Product setLastPriceAndKdvRate(Product product){

        ProductType productType = product.getProductType();
        Kdv kdv = kdvDao.getByProductType(productType);
        BigDecimal kdvRate = kdv.getKdvRate();
        BigDecimal firstPrice = product.getFirstPrice();
        BigDecimal tmp = firstPrice.multiply(kdvRate);
        BigDecimal kdvPrice = tmp.divide(BigDecimal.valueOf(100));
        BigDecimal lastPrice = firstPrice.add(kdvPrice);
        product.setLastPrice(lastPrice);
        product.setKdvRate(kdvRate);

        return product;
    }
}
