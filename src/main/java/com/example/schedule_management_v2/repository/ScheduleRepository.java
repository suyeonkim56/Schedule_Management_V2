package com.example.schedule_management_v2.repository;

import com.example.schedule_management_v2.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
