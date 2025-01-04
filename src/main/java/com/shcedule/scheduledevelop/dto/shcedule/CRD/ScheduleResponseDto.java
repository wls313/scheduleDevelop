package com.shcedule.scheduledevelop.dto.shcedule.CRD;

import java.time.LocalDateTime;

public record ScheduleResponseDto(
        Long id,
        String title,
        String writer,
        String contents,
        Long memberId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
