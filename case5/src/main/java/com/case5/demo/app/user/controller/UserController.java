package com.case5.demo.app.user.controller;

import com.case5.demo.app.gen.dto.RestResponse;
import com.case5.demo.app.user.dto.UserDto;
import com.case5.demo.app.user.dto.UserUpdateRequestDto;
import com.case5.demo.app.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity save(@RequestBody UserDto userDto){

        userDto = userService.save(userDto);

        return ResponseEntity.ok(RestResponse.of(userDto));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UserUpdateRequestDto userUpdateRequestDto){

        UserDto userDto = userService.update(userUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        userService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }


}
