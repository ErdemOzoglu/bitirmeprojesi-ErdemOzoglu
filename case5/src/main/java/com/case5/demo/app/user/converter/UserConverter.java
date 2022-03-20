package com.case5.demo.app.user.converter;

import com.case5.demo.app.user.dto.UserDto;
import com.case5.demo.app.user.dto.UserUpdateRequestDto;
import com.case5.demo.app.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    User convertToUser(UserDto userSaveRequestDto);
    UserDto convertToUserDto(User user);

    User convertUpdateRequestDtoToUser(UserUpdateRequestDto userUpdateRequestDto);

}
