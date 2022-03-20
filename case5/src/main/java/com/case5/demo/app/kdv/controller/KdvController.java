package com.case5.demo.app.kdv.controller;

import com.case5.demo.app.gen.dto.RestResponse;
import com.case5.demo.app.kdv.dto.KdvDto;
import com.case5.demo.app.kdv.dto.KdvUpdateRequestDto;
import com.case5.demo.app.kdv.service.KdvService;
import com.case5.demo.app.product.dto.ProductDto;
import com.case5.demo.app.product.dto.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kdv")
@RequiredArgsConstructor
public class KdvController {

    private final KdvService kdvService;

    @PostMapping
    public ResponseEntity save(@RequestBody KdvDto kdvDto){

        kdvDto = kdvService.save(kdvDto);

        return ResponseEntity.ok(RestResponse.of(kdvDto));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody KdvUpdateRequestDto kdvUpdateRequestDto){

        KdvDto kdvDto = kdvService.update(kdvUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(kdvDto));
    }


}
