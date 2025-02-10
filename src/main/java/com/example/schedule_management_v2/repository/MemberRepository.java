package com.example.schedule_management_v2.repository;

import com.example.schedule_management_v2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
