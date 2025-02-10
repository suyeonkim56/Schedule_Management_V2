package com.example.schedule_management_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScheduleManagementV2Application {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleManagementV2Application.class, args);
    }

}
