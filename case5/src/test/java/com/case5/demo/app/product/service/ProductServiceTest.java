package com.case5.demo.app.product.service;

import com.case5.demo.app.gen.exceptions.ItemNotFoundException;
import com.case5.demo.app.kdv.dao.KdvDao;
import com.case5.demo.app.product.converter.ProductListConverter;
import com.case5.demo.app.product.dto.ProductDto;
import com.case5.demo.app.product.dto.ProductSaveRequestDto;
import com.case5.demo.app.product.entity.Product;
import com.case5.demo.app.product.enums.ProductType;
import com.case5.demo.app.product.service.entityservice.ProductEntityService;
import com.case5.demo.app.product.util.SetterUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductEntityService productEntityService;

    @Mock
    private KdvDao kdvDao;

    @Mock
    private ProductListConverter productListConverter;

    @Mock
    private SetterUtil setterUtil;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setLastPriceAndKdvRate() {
    }

    @Test
    void shouldSave() {

        ProductSaveRequestDto productSaveRequestDto = mock(ProductSaveRequestDto.class);

        Product product = mock(Product.class);

        when(product.getFirstPrice()).thenReturn(new BigDecimal(20));
        when(setterUtil.setLastPriceAndKdvRate(any())).thenReturn(product);
        when(productEntityService.save(any())).thenReturn(product);

        ProductDto testReturn = productService.save(productSaveRequestDto);

        assertEquals(new BigDecimal(20), testReturn.getFirstPrice());

    }


    @Test
    void update() {
    }

    @Test
    void shouldDelete() {

        Product product = mock(Product.class);

        when(productEntityService.getByIdWithControl(anyLong())).thenReturn(product);

        productService.delete(anyLong());

        verify(productEntityService).getByIdWithControl(anyLong());
        verify(productEntityService).delete(any());
    }

    @Test
    void shouldNotDeleteWhenIdDoesNotExist() {

        when(productEntityService.getByIdWithControl(anyLong())).thenThrow(ItemNotFoundException.class);

        assertThrows(ItemNotFoundException.class, () -> productService.delete(anyLong()));

        verify(productEntityService).getByIdWithControl(anyLong());
    }

    @Test
    void updateProductFirstPrice() {
    }

    @Test
    void shouldFindAll() {
        Product product = mock(Product.class);
        List<Product> productList = new ArrayList<>();
        productList.add(product);

        ProductDto productDto = mock(ProductDto.class);
        List<ProductDto>  productDtoList = new ArrayList<>();
        productDtoList.add(productDto);

        when(productEntityService.findAll()).thenReturn(productList);
        when(productListConverter.convertToProductDtoList(productList)).thenReturn(productDtoList);

        List<ProductDto> testReturn = productService.findAll();

        assertEquals(1, testReturn.size());
    }

    @Test
    void shouldFindAllWhenCustomerListIsEmpty() {

        List<Product> productList = new ArrayList<>();
        List<ProductDto> productDtoList = new ArrayList<>();

        when(productEntityService.findAll()).thenReturn(productList);
        when(productListConverter.convertToProductDtoList(productList)).thenReturn(productDtoList);

        List<ProductDto> testReturn = productService.findAll();

        assertEquals(productDtoList.size(), testReturn.size());
    }

    @Test
    void shouldFindAllWhenCustomerListIsNull() {

        when(productEntityService.findAll()).thenReturn(null);
        when(productListConverter.convertToProductDtoList(null)).thenCallRealMethod();

        assertThrows(NullPointerException.class, () -> productService.findAll());
    }

    @Test
    void shouldFindAllByProductType() {
        ProductType productType = ProductType.GIDA;
        List<Product> productList = new ArrayList<>();
        List<ProductDto> productDtoList = new ArrayList<>();

        when(productEntityService.findAllByProductType(any())).thenReturn(productList);
        when(productListConverter.convertToProductDtoList(productList)).thenReturn(productDtoList);


        List<ProductDto> testReturn =  productService.findAllByProductType(productType);

        assertEquals(productDtoList.size(), testReturn.size());
    }




    @Test
    void updateProductForKdvRateChange() {
    }
}