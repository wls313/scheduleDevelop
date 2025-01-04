package com.shcedule.scheduledevelop.dto.shcedule.CRD;

import com.shcedule.scheduledevelop.common.entity.Schedule;

import java.time.LocalDateTime;

public record ScheduleResponseDto(
        String title,
        String writer,
        String contents
) {
    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getTitle(), schedule.getWriter(),  schedule.getContents());
    }
}
