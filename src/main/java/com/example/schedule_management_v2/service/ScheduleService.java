package com.example.schedule_management_v2.service;

import com.example.schedule_management_v2.dto.ScheduleResponseDto;
import com.example.schedule_management_v2.dto.ScheduleWithEmailResponseDto;
import com.example.schedule_management_v2.entity.Member;
import com.example.schedule_management_v2.entity.Schedule;
import com.example.schedule_management_v2.repository.MemberRepository;
import com.example.schedule_management_v2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //일정 전체 조회
    public List<ScheduleResponseDto> findAll() {

        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    public ScheduleWithEmailResponseDto findById(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        Member writer = findSchedule.getMember();
        return new ScheduleWithEmailResponseDto(findSchedule.getTitle(), findSchedule.getContents(), writer.getEmail());
    }

    //일정 삭제
    public void deleteSchedule(Long id) {
        Schedule findSchedule =  scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);
    }
}
