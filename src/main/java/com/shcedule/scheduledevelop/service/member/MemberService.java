package com.shcedule.scheduledevelop.service.member;

import com.shcedule.scheduledevelop.common.config.PasswordEncoder;
import com.shcedule.scheduledevelop.common.entity.Member;
import com.shcedule.scheduledevelop.common.exception.MemberIdException;
import com.shcedule.scheduledevelop.dto.member.CRD.MemberDto;
import com.shcedule.scheduledevelop.dto.member.CRD.MemberRequestDto;
import com.shcedule.scheduledevelop.dto.member.CRD.MemberResponseDto;
import com.shcedule.scheduledevelop.repository.member.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;

    public MemberDto createMember(MemberRequestDto requestDto) {
        Member member = Member.create(requestDto.memberId(),requestDto.memberName(),requestDto.email(),encoder.encode(requestDto.password()));
        memberRepository.save(member);

        return MemberDto.from(member);
    }

    public MemberResponseDto findByMemberId(String memberId){
        Member member = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new MemberIdException(memberId));

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
                .orElseThrow(() -> new MemberIdException(memberId));

            member.updateMember(memberName,email);
    }

    public void deleteMember(String memberId) {
        Member member = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new MemberIdException(memberId));

        memberRepository.delete(member);
    }
}
