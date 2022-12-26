/*
 * package com.example.tour.repository;
 * 
 * 
 * import org.springframework.data.domain.Page; import
 * org.springframework.data.domain.Pageable; import
 * org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Query; import
 * org.springframework.data.repository.query.Param;
 * 
 * 
 * import com.example.tour.model.TourBoard;
 * 
 * public interface BoardRepository extends JpaRepository<TourBoard, Long>{
 * 
 * public Page<TourBoard> findByTitleContaining(String ttitle, Pageable
 * pageable); public Page<TourBoard> findByContentContaining(String tcontent,
 * Pageable pageable);
 * 
 * //제목 검색 개수
 * 
 * @Query(value =
 * ("select count(*) from tour_board where ttitle like CONCAT('%',:word,'%')"),
 * nativeQuery = true) public Long cntTitleSearch(@Param("word") String word);
 * 
 * @Query(value =
 * ("select count(*) from tour_board where tcontent like CONCAT('%',:word,'%')"
 * ), nativeQuery = true) public Long cntContentSearch(@Param("word") String
 * word);
 * 
 * }
 */
