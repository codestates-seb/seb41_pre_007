package com.pre007.server.member_미완.repository;

import com.pre007.server.member_미완.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
