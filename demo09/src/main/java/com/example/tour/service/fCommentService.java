package com.example.tour.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tour.model.FreeBoard;
import com.example.tour.model.FreeComment;
import com.example.tour.repository.FreeboardRepository;
import com.example.tour.repository.fCommentRepository;




@Service
public class fCommentService {
	@Autowired
	private fCommentRepository fcommentRepository;
	@Autowired
	private FreeboardRepository fboardRepository;
	
	//?Œ“ê¸?ì¶”ê?
	@Transactional
	public void insert(FreeComment comment) {
		 //commentRepository.save(comment);
		
		//replyCnt + 1
		FreeBoard b =  fboardRepository.findById(comment.getFreeboard().getNum()).get();
		b.setReplycnt(b.getReplycnt()+1);
		
		
		//SQL
		fcommentRepository.insert(
				comment.getFcontent(),
				comment.getFreeboard().getNum(),
				comment.getMember().getNum());
	}
	
	public List<FreeComment> list(Long fbnum){
		return fcommentRepository.findByFbnum(fbnum);
	}
	//?Œ“ê¸??‚­? œ
	@Transactional
public void delete(Long fcnum) {
		Optional<FreeComment> c = fcommentRepository.findById(fcnum);
		FreeBoard b = c.get().getFreeboard();
		b.setReplycnt(b.getReplycnt()-1);
		fcommentRepository.deleteById(fcnum);
	    
		
}

	}

