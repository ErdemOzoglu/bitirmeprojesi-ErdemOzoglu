package com.case5.demo.app.product.service.entityservice;

import com.case5.demo.app.gen.service.BaseEntityService;
import com.case5.demo.app.product.dao.ProductDao;
import com.case5.demo.app.product.entity.Product;
import com.case5.demo.app.product.enums.ProductType;
import org.springframework.stereotype.Service;

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
}
