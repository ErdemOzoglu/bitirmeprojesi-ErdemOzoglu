package com.case5.demo.app.product.service.entityservice;

import com.case5.demo.app.gen.service.BaseEntityService;
import com.case5.demo.app.product.dao.ProductDao;
import com.case5.demo.app.product.dto.ProductDetailDto;
import com.case5.demo.app.product.dto.ProductDto;
import com.case5.demo.app.product.entity.Product;
import com.case5.demo.app.product.enums.ProductType;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductDao> {
    public ProductEntityService(ProductDao dao) {
        super(dao);
    }

    public List<Product> findAllByProductType(ProductType productType){
        return getDao().findAllByProductType(productType);
    }

    public List<ProductDetailDto> getAllProductDetails(){
        return getDao().getAllProductDetails();
    }

    public List<ProductDto> getProductsByLastPriceBetween( BigDecimal minPrice, BigDecimal maxPrice){
        return getDao().getProductsByLastPriceBetween(minPrice,maxPrice);
    }



}
