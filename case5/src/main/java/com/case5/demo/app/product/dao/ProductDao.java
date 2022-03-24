package com.case5.demo.app.product.dao;

import com.case5.demo.app.product.dto.ProductDetailDto;
import com.case5.demo.app.product.dto.ProductDto;
import com.case5.demo.app.product.entity.Product;
import com.case5.demo.app.product.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findAllByProductType(ProductType productType);

    @Query(
            "select new com.case5.demo.app.product.dto.ProductDetailDto( " +
                    "product.productType," +
                    "kdv.kdvRate," +
                    "min(product.lastPrice), " +
                    "max(product.lastPrice), " +
                    "avg(product.lastPrice), " +
                    "count(product.id)" +
                    ") " +
                    "from Product product " +
                    "inner join Kdv kdv " +
                    "on product.productType = kdv.productType " +
                    "group by product.productType, kdv.kdvRate"
    )
    List<ProductDetailDto> getAllProductDetails();


    @Query(
            "select new com.case5.demo.app.product.dto.ProductDto( " +
                    "product.productName," +
                    "product.productType," +
                    "product.firstPrice, " +
                    "product.lastPrice, " +
                    "product.kdvRate " +
                    ") " +
                    "from Product product " +
                    "where product.lastPrice between :minPrice and :maxPrice"
    )
    List<ProductDto> getProductsByLastPriceBetween(@Param("minPrice")BigDecimal minPrice,@Param("maxPrice") BigDecimal maxPrice);

}
