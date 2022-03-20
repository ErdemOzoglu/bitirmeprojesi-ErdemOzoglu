package com.case5.demo.app.product.converter;

import com.case5.demo.app.product.dto.ProductDto;
import com.case5.demo.app.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductListConverter {

    public List<ProductDto> convertToProductDtoList(List<Product> productList) {

        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {

            ProductDto productDto = convertToProductDto(product);

            productDtoList.add(productDto);
        }

        return productDtoList;
    }


    public ProductDto convertToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductName(product.getProductName());
        productDto.setFirstPrice(product.getFirstPrice());
        productDto.setKdvRate(product.getKdvRate());
        productDto.setProductType(product.getProductType());
        productDto.setLastPrice(product.getLastPrice());
        return productDto;
    }

}
