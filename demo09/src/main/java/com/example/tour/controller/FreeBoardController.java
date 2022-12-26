package com.example.tour.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.tour.auth.PrincipalUser;
import com.example.tour.model.FreeBoard;
import com.example.tour.service.FreeboardService;
import com.example.tour.service.TourService;

@Controller
@RequestMapping("/freeboard/*")
public class FreeBoardController {
	@Autowired
	private FreeboardService fservice;
	@Autowired
	private TourService tservice;
	
	
	
	@GetMapping("board")
	public String freeboard(Model model, @PageableDefault(size = 5, sort = "num", direction = Direction.DESC)Pageable pageable,
			 @RequestParam(required = false, defaultValue = "")String field,
			 @RequestParam(required = false, defaultValue = "")String word) {

		
		Page<FreeBoard> lists = fservice.findAll(field, word, pageable);
		Long count = fservice.count(field, word);
		int currentPage= lists.getPageable().getPageNumber();
		int countPage = lists.getTotalPages();
        int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
        int endPage = Math.min(lists.getPageable().getPageNumber()+3, lists.getTotalPages());
 
        model.addAttribute("rowNo", count-(currentPage*countPage));
        model.addAttribute("currentPage", currentPage+1);
        model.addAttribute("countPage", countPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
		model.addAttribute("count", count);
		model.addAttribute("freeboard", lists);
		
		return "/freeboard/freeboard";
	}
	
	  @GetMapping("insert")
	  @PreAuthorize("isAuthenticated()")
	  public String insert() {
		  return "/freeboard/freeboardinsert";
	  }
	  
	  @PostMapping("insert")
	  public String insert(FreeBoard fboard, HttpSession session,@AuthenticationPrincipal PrincipalUser principal)
	  {   
		 String uploadFolder = session.getServletContext().getRealPath("/")+"\\resources\\img";
		fservice.fileInsert(fboard, principal.getMember(), uploadFolder);
		  return "redirect:board";
	  }
	//�󼼺���
		@GetMapping("view/{num}")
		public String view(@PathVariable Long num, Model model) {
			model.addAttribute("freeboard", fservice.findById(num));
			return "/freeboard/freeboardview";
		}
		
		
		//����
		@DeleteMapping("delete/{num}")
		@ResponseBody
		public String delete(@PathVariable Long num){
			fservice.delete(num);
			return "success";
		}
		
		//������
		@GetMapping("update/{num}")
		public String update(@PathVariable Long num, Model model) {
			model.addAttribute("freeboard", fservice.findById(num));
			return "/freeboard/freeboardupdate";
		}
		
		@PutMapping("update")
		@ResponseBody
		public String update(@RequestBody FreeBoard fboard) {
			fservice.update(fboard);
			return "success";
		}
		//1
		@GetMapping("yeonje/{num}")
		public String yeonje(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.yeonjeview(num));
			return "/tour/tourView";
		}
		//2
		@GetMapping("saha/{num}")
		public String saha(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.sahaview(num));
			return "/tour/tourView";
			//3
		}	@GetMapping("dongrae/{num}")
		public String dongrae(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.dongraeview(num));
			return "/tour/tourView";
			//4
		}	@GetMapping("namgu/{num}")
		public String namgu(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.namguview(num));
			return "/tour/tourView";
			//5
		}	@GetMapping("geomjung/{num}")
		public String geomjung(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.geomjungview(num));
			return "/tour/tourView";
			//6
		}	@GetMapping("jingu/{num}")
		public String jingu(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.jinguview(num));
			return "/tour/tourView";
			//7
		}	@GetMapping("junggu/{num}")
		public String junggu(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.jungguview(num));
			return "/tour/tourView";
			//8
		}	@GetMapping("gangseo/{num}")
		public String gangseo(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.gangseoview(num));
			return "/tour/tourView";
			//9
		}	@GetMapping("bukgu/{num}")
		public String bukgu(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.bukguview(num));
			return "/tour/tourView";
			//10
		}	@GetMapping("sasang/{num}")
		public String sasang(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.sasangview(num));
			return "/tour/tourView";
			//11
		}	@GetMapping("seogu/{num}")
		public String seogu(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.seoguview(num));
			return "/tour/tourView";
			//12
		}	@GetMapping("suyoung/{num}")
		public String suyoung(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.suyoungview(num));
			return "/tour/tourView";
			//13
		}	@GetMapping("youngdo/{num}")
		public String youngdo(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.youngdoview(num));
			return "/tour/tourView";
			//14
		}	@GetMapping("haeundae/{num}")
		public String haeundae(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.haeundaeview(num));
			return "/tour/tourView";
			//15
		}	@GetMapping("donggu/{num}")
		public String donggu(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.dongguview(num));
			return "/tour/tourView";
			//16
		}	@GetMapping("gijang/{num}")
		public String gijang(@PathVariable Long num, Model model) {
			model.addAttribute("tboard", fservice.gijangview(num));
			return "/tour/tourView";
		}

}
	  
		
