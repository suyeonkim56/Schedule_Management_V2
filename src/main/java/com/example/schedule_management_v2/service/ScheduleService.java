package com.example.schedule_management_v2.service;

import com.example.schedule_management_v2.dto.ScheduleResponseDto;
import com.example.schedule_management_v2.entity.Member;
import com.example.schedule_management_v2.entity.Schedule;
import com.example.schedule_management_v2.repository.MemberRepository;
import com.example.schedule_management_v2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final MemberRepository memberRepository;
    private final ScheduleRepository scheduleRepository;

    //일정 생성
    public ScheduleResponseDto save(String title, String contents, String username) {

        Member findmember = memberRepository.findMemberByUsernameOrElseThrow(username);
        Schedule schedule = new Schedule(title, contents);
        schedule.setMember(findmember);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(),savedSchedule.getContents());
    }
}
