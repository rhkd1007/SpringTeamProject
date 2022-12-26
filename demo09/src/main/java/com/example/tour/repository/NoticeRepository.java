package com.example.tour.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tour.model.NoticeBoard;

public interface NoticeRepository extends JpaRepository<NoticeBoard, Long>{

		//	전체보기 검색 페이징
		public Page<NoticeBoard> findByNbtitleContaining(String nbtitle, Pageable npageable);
		public Page<NoticeBoard> findByNbcontentContaining(String nbtitle, Pageable npageable);
			
		//제목 검색 개수
		@Query(value = "select count(*) from notice_board where nbtitle like CONCAT('%',:nword,'%')", nativeQuery = true)
		public Long cntTitleSearch(@Param("nword") String nword);
			
		@Query(value = "select count(*) from notice_board where nbcontent like CONCAT('%',:nword,'%')", nativeQuery = true)
		public Long cntContentSearch(@Param("nword") String nword);
	
	
}
