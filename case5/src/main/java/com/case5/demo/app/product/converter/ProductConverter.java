package com.case5.demo.app.product.converter;

import com.case5.demo.app.product.dto.ProductDto;
import com.case5.demo.app.product.dto.ProductSaveRequestDto;
import com.case5.demo.app.product.dto.ProductUpdateRequestDto;
import com.case5.demo.app.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    Product convertSaveRequestDtoToProduct(ProductSaveRequestDto productSaveRequestDto);
    ProductSaveRequestDto convertProductToSaveRequestDto(Product product);

    Product convertDtoToProduct(ProductDto productDto);
    ProductDto convertProductToProductDto(Product product);

    Product convertUpdateRequestDtoToProduct(ProductUpdateRequestDto productUpdateRequestDto);
}
