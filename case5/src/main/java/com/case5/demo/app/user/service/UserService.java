package com.case5.demo.app.user.service;

import com.case5.demo.app.user.converter.UserConverter;
import com.case5.demo.app.user.dto.UserDto;
import com.case5.demo.app.user.dto.UserUpdateRequestDto;
import com.case5.demo.app.user.entity.User;
import com.case5.demo.app.user.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityService userEntityService;
    private final PasswordEncoder passwordEncoder;

    public UserDto save(UserDto userDto){

        User user = UserConverter.INSTANCE.convertToUser(userDto);

        String password = passwordEncoder.encode(user.getPassword());

        user.setPassword(password);

        user = userEntityService.save(user);

        userDto = UserConverter.INSTANCE.convertToUserDto(user);

        return userDto;
    }

    public UserDto update(UserUpdateRequestDto userUpdateRequestDto){

        User user = UserConverter.INSTANCE.convertUpdateRequestDtoToUser(userUpdateRequestDto);

        user = userEntityService.save(user);

        UserDto userDto = UserConverter.INSTANCE.convertToUserDto(user);

        return userDto;
    }

    public void delete(Long id) {

        User user = userEntityService.getByIdWithControl(id);

        userEntityService.delete(user);
    }


}
