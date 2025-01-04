package com.shcedule.scheduledevelop.dto.shcedule.CRD;

import com.shcedule.scheduledevelop.common.entity.Schedule;

import java.time.LocalDateTime;

public record ScheduleDto(
        String title,
        String writer,
        String contents,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ScheduleDto from(Schedule schedule) {
        return new ScheduleDto(
                schedule.getTitle(),
                schedule.getWriter(),
                schedule.getContents(),
                schedule.getCreateAt(),
                schedule.getUpdatedAt()
        );
    }
}
