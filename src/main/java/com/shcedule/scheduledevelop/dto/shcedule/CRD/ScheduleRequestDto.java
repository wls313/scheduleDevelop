package com.shcedule.scheduledevelop.dto.shcedule.CRD;

import jakarta.validation.constraints.NotBlank;

public record ScheduleRequestDto (
  @NotBlank
  String writer,
  @NotBlank
  String title,
  @NotBlank
  String contents
){
}
