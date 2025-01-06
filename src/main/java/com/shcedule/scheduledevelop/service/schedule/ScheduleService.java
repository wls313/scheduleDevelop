package com.shcedule.scheduledevelop.service.schedule;

import com.shcedule.scheduledevelop.common.entity.Member;
import com.shcedule.scheduledevelop.common.entity.Schedule;
import com.shcedule.scheduledevelop.common.exception.MemberNameException;
import com.shcedule.scheduledevelop.common.exception.ScheduleIdException;
import com.shcedule.scheduledevelop.dto.shcedule.CRD.ScheduleDto;
import com.shcedule.scheduledevelop.dto.shcedule.CRD.ScheduleRequestDto;
import com.shcedule.scheduledevelop.dto.shcedule.CRD.ScheduleResponseDto;
import com.shcedule.scheduledevelop.repository.member.MemberRepository;
import com.shcedule.scheduledevelop.repository.schedule.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository;

    public ScheduleDto createSchedule(ScheduleRequestDto requestDto) {
        String memberName = requestDto.writer();

        Member member = memberRepository.findByMemberName(memberName)
                .orElseThrow(() -> new MemberNameException(memberName));

        Schedule schedule = Schedule.create(requestDto.title(),requestDto.writer(),requestDto.contents(),member);
        scheduleRepository.save(schedule);

        return ScheduleDto.from(schedule);
    }

    public List<ScheduleResponseDto> findByWriterAll(String writer) {
        return scheduleRepository.findByWriter(writer)
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, String title,String contents) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleIdException(id));

        schedule.updateSchedule(title,contents);

        return new ScheduleResponseDto(schedule.getTitle(), schedule.getWriter(), schedule.getContents());
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
