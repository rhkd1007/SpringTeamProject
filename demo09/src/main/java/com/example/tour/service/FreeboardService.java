package com.example.tour.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.tour.model.Bukgu;
import com.example.tour.model.Donggu;
import com.example.tour.model.Dongrae;
import com.example.tour.model.FreeBoard;
import com.example.tour.model.Gangseo;
import com.example.tour.model.Geomjung;
import com.example.tour.model.Haeundae;
import com.example.tour.model.Jingu;
import com.example.tour.model.Junggu;
import com.example.tour.model.Member;
import com.example.tour.model.Namgu;
import com.example.tour.model.Saha;
import com.example.tour.model.Sasang;
import com.example.tour.model.Seogu;
import com.example.tour.model.Suyoung;
import com.example.tour.model.TourDTO;
import com.example.tour.model.Yeonje;
import com.example.tour.model.Youngdo;
import com.example.tour.repository.BukguRepository;
import com.example.tour.repository.DongguRepository;
import com.example.tour.repository.DongraeRepository;
import com.example.tour.repository.FreeboardRepository;
import com.example.tour.repository.GangseoRepository;
import com.example.tour.repository.GeomjungRepository;
import com.example.tour.repository.HaeundaeRepository;
import com.example.tour.repository.JinguRepository;
import com.example.tour.repository.JungguRepository;
import com.example.tour.repository.NamguRepository;
import com.example.tour.repository.SahaRepository;
import com.example.tour.repository.SasangRepository;
import com.example.tour.repository.SeoguRepository;
import com.example.tour.repository.SuyoungRepository;
import com.example.tour.repository.TourRepository;
import com.example.tour.repository.YeonjeRepository;
import com.example.tour.repository.YoungdoRepository;

@Transactional(readOnly = true)
@Service
public class FreeboardService {
	@Autowired
	private FreeboardRepository freeboardRepository;
	@Autowired
	private YeonjeRepository yeonjeReopsitory;
	@Autowired
	private GangseoRepository gangseoRepository;
	@Autowired
	private BukguRepository bukguRepository;
	@Autowired
	private SasangRepository sasangRepository;
	@Autowired
	private SuyoungRepository suyoungRepository;
	@Autowired
	private YoungdoRepository youngdoRepository;
	@Autowired
	private TourRepository gijangRepository;
	@Autowired
	private DongguRepository dongguRepository;
	@Autowired
	private JungguRepository jungguRepository;
	@Autowired
	private SeoguRepository seoguRepository;
	@Autowired
	private NamguRepository namguRepository;
	@Autowired
	private JinguRepository jinguRepository;
	@Autowired
	private HaeundaeRepository haeundaeRepository;
	@Autowired
	private GeomjungRepository geomjungRepository;
	@Autowired
	private DongraeRepository dongraeRepository;
	@Autowired
	private SahaRepository sahaRepository;

	@Transactional
	public void fileInsert(FreeBoard fboard, Member member, 
			  String uploadFolder) {
		fboard.setMember(member);
		UUID uuid = UUID.randomUUID();
		MultipartFile f =  fboard.getUpload();
		String uploadFileName = "";
		if(!f.isEmpty()) { // ���ϼ��õ�
			uploadFileName=uuid.toString()+"_"+f.getOriginalFilename();
			File saveFile = new File(uploadFolder,uploadFileName);
	
			try {
				f.transferTo(saveFile); //���� ���ε�
				fboard.setFileimage(uploadFileName);
			} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
			} 
		}
		freeboardRepository.save(fboard);	
	}
	
	
	
	/*
	 * public void fileInsert(FreeBoard fboard, String uploadFolder) { UUID uuid =
	 * UUID.randomUUID(); MultipartFile f = fboard.getUpload(); String
	 * uploadFileName = ""; if(!f.isEmpty()) { // ���ϼ��õ�
	 * uploadFileName=uuid.toString()+"_"+f.getOriginalFilename(); File saveFile =
	 * new File(uploadFolder,uploadFileName);
	 * 
	 * try { f.transferTo(saveFile); //���� ���ε� fboard.setFileimage(uploadFileName); }
	 * catch (IllegalStateException | IOException e) { e.printStackTrace(); } }
	 * freeboardRepository.save(fboard); }
	 */
	
	
	
	
	
	public List<FreeBoard>list(){
		return freeboardRepository.findAll();
	}
	
	public Page<FreeBoard> findAll(String field, String word, Pageable pageable){
		Page<FreeBoard> lists = freeboardRepository.findAll(pageable);
		if(field.equals("title")) {
			lists=freeboardRepository.findByTitleContaining(word, pageable);
		}else if(field.equals("content")) {
			lists=freeboardRepository.findByContentContaining(word, pageable);
		}
		return lists;
	}
	
	public Long count(String field, String word) {
		Long count = freeboardRepository.count();
		if(field.equals("title")) {
			count = freeboardRepository.cntTitleSearch(word);
		}else if(field.equals("content")) {
			count = freeboardRepository.cntContentSearch(word);
		}
		return count;
	}
	
	//�󼼺���
	@Transactional
	public FreeBoard findById(Long num) {
		FreeBoard board = freeboardRepository.findById(num).get();
		board.setHitcnt(board.getHitcnt()+1);
		return board;
	}
	@Transactional
	public Yeonje yeonjeview(Long num) {
		Yeonje yeonje = yeonjeReopsitory.findById(num).get();
		
		return yeonje;
	}
	@Transactional
	public Donggu dongguview(Long num) {
		Donggu donggu = dongguRepository.findById(num).get();
		
		return donggu;
	}
	@Transactional
	public Haeundae haeundaeview(Long num) {
		Haeundae haeundae = haeundaeRepository.findById(num).get();
		
		return haeundae;
	}
	@Transactional
	public Youngdo youngdoview(Long num) {
		Youngdo youngdo = youngdoRepository.findById(num).get();
		
		return youngdo;
	}
	@Transactional
	public Suyoung suyoungview(Long num) {
		Suyoung suyoung = suyoungRepository.findById(num).get();
		
		return suyoung;
	}
	@Transactional
	public Seogu seoguview(Long num) {
		Seogu seogu = seoguRepository.findById(num).get();
		
		return seogu;
	}
	@Transactional
	public Sasang sasangview(Long num) {
		Sasang sasang = sasangRepository.findById(num).get();
		
		return sasang;
	}
	@Transactional
	public Bukgu bukguview(Long num) {
		Bukgu bukgu = bukguRepository.findById(num).get();
		
		return bukgu;
	}
	@Transactional
	public Gangseo gangseoview(Long num) {
		Gangseo gangseo = gangseoRepository.findById(num).get();
		
		return gangseo;
	}
	@Transactional
	public Junggu jungguview(Long num) {
		Junggu junggu = jungguRepository.findById(num).get();
		
		return junggu;
	}
	@Transactional
	public Jingu jinguview(Long num) {
		Jingu jingu = jinguRepository.findById(num).get();
		
		return jingu;
	}
	@Transactional
	public Geomjung geomjungview(Long num) {
		Geomjung geomjung = geomjungRepository.findById(num).get();
		
		return geomjung;
	}
	@Transactional
	public Namgu namguview(Long num) {
		Namgu namgu = namguRepository.findById(num).get();
		
		return namgu;
	}
	@Transactional
	public Dongrae dongraeview(Long num) {
		Dongrae dongrae = dongraeRepository.findById(num).get();
		
		return dongrae;
	}
	@Transactional
	public Saha sahaview(Long num) {
		Saha saha = sahaRepository.findById(num).get();
		
		return saha;
	}
	@Transactional
	public TourDTO gijangview(Long num) {
		TourDTO gijang = gijangRepository.findById(num).get();
		
		return gijang;
	}
	
	//����
	@Transactional
	public void delete(Long num) {
		freeboardRepository.deleteById(num);
	}
	
	//����==>��Ƽüŷ
	@Transactional
	public void update(FreeBoard board) {
		FreeBoard b = freeboardRepository.findById(board.getNum()).get();
		b.setTitle(board.getTitle());
		b.setContent(board.getContent());
		b.setRegdate(new Date());
		
	}






	

	
}
