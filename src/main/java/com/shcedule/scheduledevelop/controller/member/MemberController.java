package com.shcedule.scheduledevelop.controller.member;

import com.shcedule.scheduledevelop.dto.member.MemberDto;
import com.shcedule.scheduledevelop.dto.member.MemberRequestDto;
import com.shcedule.scheduledevelop.dto.member.MemberResponseDto;
import com.shcedule.scheduledevelop.service.member.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberDto> save(@Valid @RequestBody MemberRequestDto requestDto) {
        MemberDto response = memberService.createMember(requestDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> findByMemberId(@PathVariable String memberId){
        MemberResponseDto memberResponseDto = memberService.findByMemberId(memberId);

        return new ResponseEntity<>(memberResponseDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> findAll(){
        List<MemberResponseDto> memberResponseDtoList = memberService.findAll();

        return new ResponseEntity<>(memberResponseDtoList,HttpStatus.OK);
    }
}
