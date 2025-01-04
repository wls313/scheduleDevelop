package com.shcedule.scheduledevelop.repository.schedule;

import com.shcedule.scheduledevelop.common.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

}
