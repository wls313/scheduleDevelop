package com.shcedule.scheduledevelop.common.exception;

public class MemberIdException extends RuntimeException{
    public MemberIdException(String memberId){
        super(memberId + "를 가진 사용자가 존재하지않습니다.");
    }
}
