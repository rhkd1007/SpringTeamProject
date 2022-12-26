package com.example.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tour.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	 Member findByUsername(String username);
}
