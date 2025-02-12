package com.example.schedule_management_v2.service;

import com.example.schedule_management_v2.dto.MemberResponseDto;
import com.example.schedule_management_v2.dto.SignupRequestDto;
import com.example.schedule_management_v2.dto.SignupResponseDto;
import com.example.schedule_management_v2.entity.Member;
import com.example.schedule_management_v2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //유저 회원가입
    public SignupResponseDto signUp(String username, String password, String email) {
        Member member = new Member(username, password, email);

        Member savedMember = memberRepository.save(member);

        return new SignupResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getEmail());
    }

    //유저 단건 조회
    public MemberResponseDto findById(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        if(optionalMember.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist id : " + id);
        }

        Member findMember = optionalMember.get();

        return new MemberResponseDto(findMember.getUsername(), findMember.getEmail());
    }
}
