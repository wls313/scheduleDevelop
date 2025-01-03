package com.shcedule.scheduledevelop.dto.member;

import lombok.Getter;
@Getter
public class MemberResponseDto {

    private final String memberName;
    private final String email;

    public MemberResponseDto(String memberName, String email) {
        this.memberName = memberName;
        this.email = email;
    }
}