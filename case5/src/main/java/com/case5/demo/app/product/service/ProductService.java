package com.case5.demo.app.product.service;

import com.case5.demo.app.kdv.dao.KdvDao;
import com.case5.demo.app.kdv.dto.KdvDto;
import com.case5.demo.app.kdv.entity.Kdv;
import com.case5.demo.app.product.converter.ProductConverter;
import com.case5.demo.app.product.converter.ProductListConverter;
import com.case5.demo.app.product.dto.ProductDetailDto;
import com.case5.demo.app.product.dto.ProductDto;
import com.case5.demo.app.product.dto.ProductSaveRequestDto;
import com.case5.demo.app.product.dto.ProductUpdateRequestDto;
import com.case5.demo.app.product.entity.Product;
import com.case5.demo.app.product.enums.ProductType;
import com.case5.demo.app.product.service.entityservice.ProductEntityService;
import com.case5.demo.app.product.util.SetterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductEntityService productEntityService;
    private final ProductListConverter productListConverter;
    private final SetterUtil setterUtil;


    public ProductDto save(ProductSaveRequestDto productSaveRequestDto){

        Product product = ProductConverter.INSTANCE.convertSaveRequestDtoToProduct(productSaveRequestDto);

        product = setterUtil.setLastPriceAndKdvRate(product);

        product = productEntityService.save(product);

        ProductDto productDto = ProductConverter.INSTANCE.convertProductToProductDto(product);

        return productDto;
    }


    public ProductDto update(ProductUpdateRequestDto productUpdateRequestDto){

        Product product= ProductConverter.INSTANCE.convertUpdateRequestDtoToProduct(productUpdateRequestDto);

        product = setterUtil.setLastPriceAndKdvRate(product);

        product = productEntityService.save(product);

        ProductDto productDto = ProductConverter.INSTANCE.convertProductToProductDto(product);

        return productDto;
    }

    public void delete(Long id) {

        Product product = productEntityService.getByIdWithControl(id);

        productEntityService.delete(product);
    }


    public ProductDto updateProductFirstPrice(Long id, BigDecimal firstPrice){

        Product product = productEntityService.getByIdWithControl(id);

        product.setFirstPrice(firstPrice);

        product = setterUtil.setLastPriceAndKdvRate(product);

        product = productEntityService.save(product);

        ProductDto productDto = ProductConverter.INSTANCE.convertProductToProductDto(product);

        return productDto;
    }

    public List<ProductDto> findAll() {

        List<Product> productList = productEntityService.findAll();

        List<ProductDto> productDtoList = productListConverter.convertToProductDtoList(productList);

        return productDtoList;
    }

    public List<ProductDto> findAllByProductType(ProductType productType){

        List<Product> productList = productEntityService.findAllByProductType(productType);

        List<ProductDto> productDtoList = productListConverter.convertToProductDtoList(productList);

        return productDtoList;
    }

    public void updateProductForKdvRateChange(KdvDto kdvDto){
        List<Product> productList = productEntityService.findAllByProductType(kdvDto.getProductType());



        for (Product product : productList) {
            product = setterUtil.setLastPriceAndKdvRate(product);

            productEntityService.save(product);

        }
    }

    public List<ProductDetailDto> getAllProductDetails(){
        return productEntityService.getAllProductDetails();
    }

    public List<ProductDto> getProductsByLastPriceBetween(BigDecimal minPrice, BigDecimal maxPrice){
        return productEntityService.getProductsByLastPriceBetween(minPrice,maxPrice);
    }

}
