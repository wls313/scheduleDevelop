package com.shcedule.scheduledevelop.repository.member;

import com.shcedule.scheduledevelop.common.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    @Query("SELECT m FROM Member m WHERE m.memberId = :memberId")
    Optional<Member> findByMemberId(@Param("memberId") String memberId);

    Optional<Member> findByMemberName(String memberName);
}
