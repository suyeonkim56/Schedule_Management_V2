package com.example.schedule_management_v2.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateTitleRequestDto {

    private final String password;

    private final String newTitle;

    public ScheduleUpdateTitleRequestDto(String password, String newTitle) {
        this.password = password;
        this.newTitle = newTitle;
    }
}
