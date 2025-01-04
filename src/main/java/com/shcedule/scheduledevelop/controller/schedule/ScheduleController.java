package com.shcedule.scheduledevelop.controller.schedule;

import com.shcedule.scheduledevelop.dto.shcedule.CRD.ScheduleDto;
import com.shcedule.scheduledevelop.dto.shcedule.CRD.ScheduleRequestDto;
import com.shcedule.scheduledevelop.service.schedule.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleDto> save(@RequestBody ScheduleRequestDto requestDto){
        ScheduleDto response = scheduleService.createSchedule(requestDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
