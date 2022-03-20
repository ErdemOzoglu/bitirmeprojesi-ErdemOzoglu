package com.case5.demo.app.kdv.dao;

import com.case5.demo.app.kdv.entity.Kdv;
import com.case5.demo.app.product.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KdvDao extends JpaRepository<Kdv, Long> {

    Kdv getByProductType(ProductType productType);

}
