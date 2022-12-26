package com.example.tour.repository;

import java.io.File;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;




import com.example.tour.model.TourBoard;

public interface FileRepository  extends JpaRepository<TourBoard,Long>{
	//JPQL(Java Persistence Query Language : ?óî?ã∞?ã∞ Í∞ùÏ≤¥Î•? Ï§ëÏã¨)
//	@Query("select sc from tbl_comment6 sc where bnum=?1") //EAGER

	public List<File> findBytnum(Long tnum);
}
