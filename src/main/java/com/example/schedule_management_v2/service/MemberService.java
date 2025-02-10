package com.example.schedule_management_v2.service;

import com.example.schedule_management_v2.dto.SignupRequestDto;
import com.example.schedule_management_v2.dto.SignupResponseDto;
import com.example.schedule_management_v2.entity.Member;
import com.example.schedule_management_v2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignupResponseDto signUp(String username, String password, String email) {
        Member member = new Member(username, password, email);

        Member savedMember = memberRepository.save(member);

        return new SignupResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getEmail());
    }
}
