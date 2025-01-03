package com.shcedule.scheduledevelop.service.member;

import com.shcedule.scheduledevelop.common.entity.Member;
import com.shcedule.scheduledevelop.dto.member.MemberDto;
import com.shcedule.scheduledevelop.dto.member.MemberRequestDto;
import com.shcedule.scheduledevelop.dto.member.MemberResponseDto;
import com.shcedule.scheduledevelop.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDto createMember(MemberRequestDto requestDto) {
        Member member = memberRepository.save(Member.of(requestDto.memberId(),requestDto.memberName(),requestDto.email(),requestDto.password()));

        return MemberDto.from(member);
    }

    public MemberResponseDto findByMemberId(String memberId){
        Member member = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,memberId+"를 가진 사용자가 존재하지않습니다."));

        return new MemberResponseDto(member.getMemberName(),member.getEmail());
    }


    public List<MemberResponseDto> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponseDto::toDto)
                .toList();

    }
}
