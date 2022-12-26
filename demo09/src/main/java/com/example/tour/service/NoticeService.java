package com.example.tour.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tour.model.Member;
import com.example.tour.model.NoticeBoard;
import com.example.tour.repository.NoticeRepository;

@Transactional(readOnly = true)
@Service
public class NoticeService {
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Transactional
	public void insert(NoticeBoard nboard, Member member) {
		nboard.setMember(member);
		noticeRepository.save(nboard);
	}
	
	public List<NoticeBoard> nlist(){
		return noticeRepository.findAll();
	}
	
	
	public Page<NoticeBoard> nfindAll(String nfield, String nword, Pageable npageable){
		Page<NoticeBoard> nlists = noticeRepository.findAll(npageable);
		if(nfield.equals("nbtitle")) {
			nlists=noticeRepository.findByNbtitleContaining(nword, npageable);
		}else if(nfield.equals("nbcontent")) {
			nlists=noticeRepository.findByNbcontentContaining(nword, npageable);
		}
		return nlists;
	}
	
	public Long count(String nfield, String nword) {
		Long count = noticeRepository.count();
		if(nfield.equals("nbtitle")) {
			count = noticeRepository.cntTitleSearch(nword);
		}else if(nfield.equals("nbcontent")) {
			count = noticeRepository.cntContentSearch(nword);
		}
		return count;
	}
	
	public Long ncount() {
		return noticeRepository.count();
	}
	
	@Transactional
	public NoticeBoard nviews(Long nbnum) {
		NoticeBoard nboard = noticeRepository.findById(nbnum).get();
		nboard.setNbhitcnt(nboard.getNbhitcnt()+1);
		
		return nboard;
	}
	
	@Transactional
	public void delete(Long nbnum) {
		noticeRepository.deleteById(nbnum);
	}
	
	@Transactional
	public void update(NoticeBoard noticeboard) {
		NoticeBoard b = noticeRepository.findById(noticeboard.getNbnum()).get();
		b.setNbtitle(noticeboard.getNbtitle());
		b.setNbcontent(noticeboard.getNbcontent());
		b.setNbregdate(new Date());
	}
	
	
}
