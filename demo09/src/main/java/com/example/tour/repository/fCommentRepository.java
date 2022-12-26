package com.example.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tour.model.FreeComment;



@Repository
public interface fCommentRepository extends JpaRepository<FreeComment, Long>{
	
	//?åìÍ∏?Ï∂îÍ?
	@Modifying
	@Query(value = "insert into free_comment(fcontent, fregdate, fbnum, user_id) values(?1, now(), ?2, ?3)",nativeQuery = true)
		public void insert(String fcontent, Long fbnum, Long user_id );
		
	//JPQL(Java Persistence Query Language : ?óî?ã∞?ã∞ Í∞ùÏ≤¥Î•? Ï§ëÏã¨)
//	@Query("select sc from tbl_comment6 sc where bnum=?1") //EAGER
	
	  @Query("select sc from free_comment sc join fetch sc.member where fbnum=?1"
	  )
	  public List<FreeComment> findByFbnum(Long fbnum);
	 
	 
	
	
}
