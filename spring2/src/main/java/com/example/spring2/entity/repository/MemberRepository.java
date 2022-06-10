package com.example.spring2.entity.repository;


import com.example.spring2.entity.Member;
import com.example.spring2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
