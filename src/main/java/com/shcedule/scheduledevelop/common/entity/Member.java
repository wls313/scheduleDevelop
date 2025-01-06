package com.shcedule.scheduledevelop.common.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "member")
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public Member(){

    }

    public static Member create(String memberId,String memberName, String email ,String password){
        Member member = new Member();

        member.memberId = memberId;
        member.memberName = memberName;
        member.email = email;
        member.password = password;

        return member;
    }

    public void updateMember(String memberName,String email) {
        if(memberName != null && !memberName.isEmpty()){
            this.memberName = memberName;
        }

        if(email != null && !email.isEmpty()){
            this.email = email;
        }
    }
}
