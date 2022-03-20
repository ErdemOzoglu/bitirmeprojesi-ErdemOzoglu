package com.case5.demo.app.kdv.converter;

import com.case5.demo.app.kdv.dto.KdvDto;
import com.case5.demo.app.kdv.dto.KdvUpdateRequestDto;
import com.case5.demo.app.kdv.entity.Kdv;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KdvConverter {

    KdvConverter INSTANCE = Mappers.getMapper(KdvConverter.class);

    Kdv convertToKdv(KdvDto kdvDto);
    KdvDto convertToKdvDto(Kdv kdv);
    Kdv convertUpdateRequestDtoToKdv(KdvUpdateRequestDto kdvUpdateRequestDto);
    KdvUpdateRequestDto convertKdvDtoToUpdateRequest(Kdv kdv);
}
