/*
 * package com.example.tour.service;
 * 
 * import java.util.Date; import java.util.List;
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 * import org.springframework.data.domain.Page; import
 * org.springframework.data.domain.Pageable; import
 * org.springframework.stereotype.Service; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.example.tour.model.Member; import
 * com.example.tour.model.TourBoard; import
 * com.example.tour.repository.BoardRepository;
 * 
 */

//@Transactional(readOnly = true)
//@Service
//public class BoardService {
//	@Autowired
//	private BoardRepository boardRepository;
	
	//Ï∂îÍ?
//	@Transactional
//	public void insert(TourBoard board, Member member) {
//		board.setMember(member);
//		boardRepository.save(board);
//	}
	
//	//?éò?ù¥Ïß? ?óÜ?ù¥ ?†ÑÏ≤¥Î≥¥Í∏?
//	public List<TourBoard> findAll(){
//		return boardRepository.findAll();
//	}
	
	//?éò?ù¥Ïß? ?è¨?ï® ?†ÑÏ≤¥Î≥¥Í∏?
//		public Page<TourBoard> findAll(Pageable pageable){
//			return boardRepository.findAll(pageable);
//		}
//		
	//?éò?ù¥Ïß? Í≤??Éâ ?†ÑÏ≤¥Î≥¥Í∏?
//		public Page<TourBoard> findAll(String field, String word, Pageable pageable){
//			Page<TourBoard> lists = boardRepository.findAll(pageable);
//			if(field.equals("ttitle")) {
//				lists = boardRepository.findByTitleContaining(word,pageable);
//			}else if(field.equals("tcontent")) {
//				lists = boardRepository.findByContentContaining(word,pageable);
//			}
//			return lists;
//		}
	
	
	
	
//}
