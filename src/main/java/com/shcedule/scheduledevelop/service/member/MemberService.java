package com.shcedule.scheduledevelop.service.member;

import com.shcedule.scheduledevelop.common.entity.Member;
import com.shcedule.scheduledevelop.dto.member.CRD.MemberDto;
import com.shcedule.scheduledevelop.dto.member.CRD.MemberRequestDto;
import com.shcedule.scheduledevelop.dto.member.CRD.MemberResponseDto;
import com.shcedule.scheduledevelop.repository.member.MemberRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public void updateMember(String memberId,String memberName,String email) {
        Member member = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,memberId+"를 가진 사용자가 존재하지않습니다."));

        if(memberName != null && !memberName.isEmpty()){
            member.updateMemberName(memberName);
        }

        if(email != null && !email.isEmpty()){
            member.updateEmail(email);
        }
    }

    public void deleteMember(String memberId) {
        Member member = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,memberId+"를 가진 사용자가 존재하지않습니다."));

        memberRepository.delete(member);
    }
}
