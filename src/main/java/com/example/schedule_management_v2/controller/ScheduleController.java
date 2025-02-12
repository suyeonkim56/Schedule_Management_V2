package com.example.schedule_management_v2.controller;

import com.example.schedule_management_v2.dto.CreateScheduleRequestDto;
import com.example.schedule_management_v2.dto.ScheduleResponseDto;
import com.example.schedule_management_v2.dto.ScheduleWithEmailResponseDto;
import com.example.schedule_management_v2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    //일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto){

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(
                requestDto.getTitle(),
                requestDto.getContents(),
                requestDto.getUsername()
        );
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    //일정 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    //특정 일정 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleWithEmailResponseDto> findById(@PathVariable Long id){
        ScheduleWithEmailResponseDto scheduleWithEmailResponseDto = scheduleService.findById(id);

        return new ResponseEntity<>(scheduleWithEmailResponseDto, HttpStatus.OK);
    }

    //일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
