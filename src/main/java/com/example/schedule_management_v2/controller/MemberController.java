package com.example.schedule_management_v2.controller;

import com.example.schedule_management_v2.dto.MemberResponseDto;
import com.example.schedule_management_v2.dto.SignupRequestDto;
import com.example.schedule_management_v2.dto.SignupResponseDto;
import com.example.schedule_management_v2.dto.MemberUpdatePasswordRequestDto;
import com.example.schedule_management_v2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //유저 회원가입
    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signUp(@RequestBody SignupRequestDto requestDto){

        SignupResponseDto signupResponseDto = memberService.signUp(
                requestDto.getUsername(),
                requestDto.getPassword(),
                requestDto.getEmail());
        return new ResponseEntity<>(signupResponseDto, HttpStatus.CREATED);
    }

    //유저 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id){
        MemberResponseDto memberResponseDto = memberService.findById(id);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    //유저 비밀번호 수정
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody MemberUpdatePasswordRequestDto requestDto
    ) {
        memberService.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
