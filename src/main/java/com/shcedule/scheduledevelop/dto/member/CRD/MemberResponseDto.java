package com.shcedule.scheduledevelop.dto.member.CRD;

import com.shcedule.scheduledevelop.common.entity.Member;

public record MemberResponseDto(String memberName, String email) {

    public static MemberResponseDto toDto(Member member) {
        return new MemberResponseDto(member.getMemberName(), member.getEmail());
    }
}