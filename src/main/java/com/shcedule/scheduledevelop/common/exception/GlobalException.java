package com.shcedule.scheduledevelop.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException extends RuntimeException{
    @ExceptionHandler(MemberIdException.class)
    public ResponseEntity<String> handleMemberIdException(MemberIdException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ScheduleIdException.class)
    public ResponseEntity<String> handleScheduleIdException(ScheduleIdException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MemberNameException.class)
    public ResponseEntity<String> handleMemberNameException(MemberNameException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
