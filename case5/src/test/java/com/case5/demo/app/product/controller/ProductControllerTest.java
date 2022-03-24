package com.case5.demo.app.product.controller;

import com.case5.demo.app.gen.BaseTest;
import com.case5.demo.app.product.dto.ProductSaveRequestDto;
import com.case5.demo.app.product.dto.ProductUpdateRequestDto;
import com.case5.demo.app.product.enums.ProductType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest()
class ProductControllerTest extends BaseTest {

    private static final String BASE_PATH = "/api/v1/product";

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Test
    void save() throws Exception {

        ProductSaveRequestDto productSaveRequestDto = ProductSaveRequestDto.builder()
                .productName("kivi")
                .productType(ProductType.GIDA)
                .firstPrice(BigDecimal.TEN)
                .build();

        String content = objectMapper.writeValueAsString(productSaveRequestDto);

        MvcResult result = mockMvc.perform(
                post(BASE_PATH).content(content).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        boolean isSuccess = isSuccess(result);

        assertTrue(isSuccess);

    }

    @Test
    void update() throws Exception {

        ProductUpdateRequestDto productUpdateRequestDto = new ProductUpdateRequestDto();
        productUpdateRequestDto.setId(253L);
        productUpdateRequestDto.setProductName("Jbl Kulaklik");
        productUpdateRequestDto.setProductType(ProductType.TEKLONOJI);
        productUpdateRequestDto.setFirstPrice(BigDecimal.valueOf(560L));


        String content = objectMapper.writeValueAsString(productUpdateRequestDto);

        MvcResult result = mockMvc.perform(
                put(BASE_PATH).content(content).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        boolean isSuccess = isSuccess(result);

        assertTrue(isSuccess);
    }

    @Test
    void deleteTest() throws Exception {

        MvcResult result = mockMvc.perform(
                delete(BASE_PATH + "/252").content("252").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        boolean isSuccess = isSuccess(result);

        assertTrue(isSuccess);
    }

    @Test
    void shouldNoDeleteWhenIdDoesNotExist() throws Exception {

        MvcResult result = mockMvc.perform(
                delete(BASE_PATH + "/9999").content("9999").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNotFound()).andReturn();

        boolean isSuccess = isSuccess(result);

        assertFalse(isSuccess);
    }

    @Test
    void updateFirstPrice() {
    }

    @Test
    void findAll() throws Exception {

        MvcResult result = mockMvc.perform(
                get(BASE_PATH).content("").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        boolean isSuccess = isSuccess(result);

        assertTrue(isSuccess);

    }

    @Test
    void findAllByProductType() {
    }

    @Test
    void getAllProductDetails() {
    }

    @Test
    void getProductsByLastPriceBetween() {
    }
}