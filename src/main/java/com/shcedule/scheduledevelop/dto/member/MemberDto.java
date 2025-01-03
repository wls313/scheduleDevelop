package com.shcedule.scheduledevelop.dto.member;

import com.shcedule.scheduledevelop.common.entity.Member;

import java.time.LocalDateTime;

public record MemberDto (
        String MemberId,
        String MemberName,
        String email,
        String password,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){
    public static MemberDto from(Member member){
        return new MemberDto(
                member.getMemberId(),
                member.getMemberName(),
                member.getEmail(),
                member.getPassword(),
                member.getCreateAt(),
                member.getUpdatedAt()
        );
    }
}
