package com.case5.demo.app.product.controller;

import com.case5.demo.app.gen.dto.RestResponse;
import com.case5.demo.app.product.dto.ProductDto;
import com.case5.demo.app.product.dto.ProductSaveRequestDto;
import com.case5.demo.app.product.dto.ProductUpdateRequestDto;
import com.case5.demo.app.product.enums.ProductType;
import com.case5.demo.app.product.service.ProductService;
import com.case5.demo.app.user.dto.UserDto;
import com.case5.demo.app.user.dto.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public ResponseEntity save(@RequestBody ProductSaveRequestDto productSaveRequestDto){

        ProductDto productDto = productService.save(productSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(productDto));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody ProductUpdateRequestDto productUpdateRequestDto){

        ProductDto productDto = productService.update(productUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(productDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        productService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateFirstPrice(@PathVariable Long id, @RequestParam BigDecimal firstPrice){

        ProductDto productDto = productService.updateProductFirstPrice(id,firstPrice);

        return ResponseEntity.ok(RestResponse.of(productDto));
    }

    @GetMapping
    public ResponseEntity findAll(){

        List<ProductDto> productDtoList = productService.findAll();

        return ResponseEntity.ok(RestResponse.of(productDtoList));
    }

    @GetMapping("/{productType}")
    public  ResponseEntity findAllByProductType(@PathVariable ProductType productType){

        List<ProductDto> productDtoList = productService.findAllByProductType(productType);

        return ResponseEntity.ok(RestResponse.of(productDtoList));
    }



}
