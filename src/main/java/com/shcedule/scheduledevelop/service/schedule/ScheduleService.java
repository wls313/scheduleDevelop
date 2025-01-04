package com.shcedule.scheduledevelop.service.schedule;

import com.shcedule.scheduledevelop.common.entity.Member;
import com.shcedule.scheduledevelop.common.entity.Schedule;
import com.shcedule.scheduledevelop.dto.member.CRD.MemberResponseDto;
import com.shcedule.scheduledevelop.dto.shcedule.CRD.ScheduleDto;
import com.shcedule.scheduledevelop.dto.shcedule.CRD.ScheduleRequestDto;
import com.shcedule.scheduledevelop.dto.shcedule.CRD.ScheduleResponseDto;
import com.shcedule.scheduledevelop.repository.member.MemberRepository;
import com.shcedule.scheduledevelop.repository.schedule.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository;

    public ScheduleDto createSchedule(ScheduleRequestDto requestDto) {
        String memberName = requestDto.writer();

        Member member = memberRepository.findByMemberName(memberName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,memberName+"를 가진 사용자가 존재하지않습니다."));

        Schedule schedule = scheduleRepository.save(Schedule.of(requestDto.title(),requestDto.writer(),requestDto.contents(),member));

        return ScheduleDto.from(schedule);
    }

    public List<ScheduleResponseDto> findByWriterAll(String writer) {
        return scheduleRepository.findByWriter(writer)
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }
}
