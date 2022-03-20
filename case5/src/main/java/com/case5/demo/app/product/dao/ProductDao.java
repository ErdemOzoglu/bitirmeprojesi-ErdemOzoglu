package com.case5.demo.app.product.dao;

import com.case5.demo.app.product.entity.Product;
import com.case5.demo.app.product.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findAllByProductType(ProductType productType);
}
