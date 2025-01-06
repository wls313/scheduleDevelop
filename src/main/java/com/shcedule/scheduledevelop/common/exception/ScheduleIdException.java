package com.shcedule.scheduledevelop.common.exception;

public class ScheduleIdException extends RuntimeException{
    public ScheduleIdException(Long id){
        super(id+"를 가진 스케쥴이 존재하지않습니다.");
    }
}
