package com.case5.demo.app.user.dto;

import lombok.Data;

@Data
public class UserUpdateRequestDto {

    private Long id;
    private String name;
    private String surname;
    private String userName;
    private String password;
}
