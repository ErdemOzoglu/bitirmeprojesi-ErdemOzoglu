package com.case5.demo.app.kdv.service;

import com.case5.demo.app.kdv.converter.KdvConverter;
import com.case5.demo.app.kdv.dao.KdvDao;
import com.case5.demo.app.kdv.dto.KdvDto;
import com.case5.demo.app.kdv.dto.KdvUpdateRequestDto;
import com.case5.demo.app.kdv.entity.Kdv;
import com.case5.demo.app.kdv.service.entityservice.KdvEntityService;
import com.case5.demo.app.product.converter.ProductConverter;
import com.case5.demo.app.product.dto.ProductDto;
import com.case5.demo.app.product.dto.ProductUpdateRequestDto;
import com.case5.demo.app.product.entity.Product;
import com.case5.demo.app.product.enums.ProductType;
import com.case5.demo.app.product.service.ProductService;
import com.case5.demo.app.product.service.entityservice.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KdvService {

    private final KdvDao kdvDao;
    private final ProductService productService;

    public KdvDto save(KdvDto kdvDto){

        Kdv kdv = KdvConverter.INSTANCE.convertToKdv(kdvDto);

        kdv = kdvDao.save(kdv);

        kdvDto = KdvConverter.INSTANCE.convertToKdvDto(kdv);

        return kdvDto;
    }

    @Transactional
    public KdvDto update(KdvUpdateRequestDto kdvUpdateRequestDto){

        Kdv kdv = KdvConverter.INSTANCE.convertUpdateRequestDtoToKdv(kdvUpdateRequestDto);

        kdv = kdvDao.save(kdv);

        KdvDto kdvDto = KdvConverter.INSTANCE.convertToKdvDto(kdv);

        productService.updateProductForKdvRateChange(kdvDto);

        return kdvDto;
    }


}
