package com.example.schedule_management_v2.service;

import com.example.schedule_management_v2.dto.MemberResponseDto;
import com.example.schedule_management_v2.dto.SignupResponseDto;
import com.example.schedule_management_v2.entity.Member;
import com.example.schedule_management_v2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    //유저 비밀번호 변경
    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        Member findmember = memberRepository.findByIdOrElseThrow(id);

        if(!findmember.getPassword().equals(oldPassword)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"비밀번호가 일치하지 않습니다.");
        }

        findmember.updatePassword(newPassword);
    }

    //유저 삭제
    public void deleteMember(Long id) {
        Member findMember =  memberRepository.findByIdOrElseThrow(id);

        memberRepository.delete(findMember);
    }

}
