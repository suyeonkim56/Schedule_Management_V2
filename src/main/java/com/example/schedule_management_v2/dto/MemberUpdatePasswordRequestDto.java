package com.example.schedule_management_v2.dto;

import lombok.Getter;

@Getter
public class MemberUpdatePasswordRequestDto {

    private final String oldPassword;

    private final String newPassword;

    public MemberUpdatePasswordRequestDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
