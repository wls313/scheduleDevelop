package com.shcedule.scheduledevelop.controller.schedule;

import com.shcedule.scheduledevelop.dto.shcedule.CRD.ScheduleDto;
import com.shcedule.scheduledevelop.dto.shcedule.CRD.ScheduleRequestDto;
import com.shcedule.scheduledevelop.dto.shcedule.CRD.ScheduleResponseDto;
import com.shcedule.scheduledevelop.service.schedule.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{writer}")
    public ResponseEntity<List<ScheduleResponseDto>> findByWriterAll(@PathVariable String writer){
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findByWriterAll(writer);

        return new ResponseEntity<>(scheduleResponseDtoList,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule (@PathVariable Long id ,@RequestBody ScheduleRequestDto requestDto){
        ScheduleResponseDto scheduleResponseDto = scheduleService.updateSchedule(id, requestDto.title(), requestDto.contents());

        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> delete (@PathVariable Long id){
        scheduleService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
