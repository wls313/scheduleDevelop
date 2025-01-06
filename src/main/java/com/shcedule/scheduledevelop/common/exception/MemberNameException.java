package com.shcedule.scheduledevelop.common.exception;

public class MemberNameException extends RuntimeException{
    public MemberNameException(String memberName){
        super(memberName + "를 가진 사용자가 존재하지않습니다.");
    }
}
