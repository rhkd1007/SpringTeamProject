package com.example.tour.repository;

import java.io.File;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;




import com.example.tour.model.TourBoard;

public interface FileRepository  extends JpaRepository<TourBoard,Long>{
	//JPQL(Java Persistence Query Language : ?��?��?�� 객체�? 중심)
//	@Query("select sc from tbl_comment6 sc where bnum=?1") //EAGER

	public List<File> findBytnum(Long tnum);
}
