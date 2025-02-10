package com.example.schedule_management_v2.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private final String username;

    private final String password;

    private final String email;

    public SignupRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
