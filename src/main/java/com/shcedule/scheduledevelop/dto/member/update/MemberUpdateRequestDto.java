package com.shcedule.scheduledevelop.dto.member.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record MemberUpdateRequestDto (
    @NotBlank
    String memberId,

    String memberName,

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
    message = "올바른 이메일 형식을 입력하세요.")
    String email
    ){

}
