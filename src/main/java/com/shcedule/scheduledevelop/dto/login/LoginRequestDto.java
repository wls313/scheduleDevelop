package com.shcedule.scheduledevelop.dto.login;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(
        @NotBlank
        String memberId,
        @NotBlank
        String password
) {
}
