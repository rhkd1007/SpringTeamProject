package com.example.tour.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.tour.model.FreeBoard;

public interface FreeboardRepository extends JpaRepository<FreeBoard, Long>{
	
	public Page<FreeBoard> findByTitleContaining(String title, Pageable pageable);
	public Page<FreeBoard> findByContentContaining(String title, Pageable pageable);
	
	//�젣紐� 寃��깋 媛쒖닔
	@Query(value="select count(*) from free_board where title like CONCAT('%',:word,'%')",
			nativeQuery=true)
	public Long cntTitleSearch(@Param("word") String word);
	
	@Query(value="select count(*) from free_board where content like CONCAT('%',:word,'%')",
			nativeQuery=true)
	public Long cntContentSearch(@Param("word") String word);
	
	public void  deleteByNum(Long num);


}
