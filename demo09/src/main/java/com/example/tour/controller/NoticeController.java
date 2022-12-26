package com.example.tour.controller;

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
import com.example.tour.model.NoticeBoard;
import com.example.tour.service.NoticeService;

@Controller
@RequestMapping("/noticeboard/*")
public class NoticeController {
	@Autowired
	private NoticeService nService;
		
	@GetMapping("nboard")
	public String noticeboard(Model model, @PageableDefault(size = 5, sort = "nbnum", direction = Direction.DESC)Pageable npageable,
			 @RequestParam(required = false, defaultValue = "")String nfield,
			 @RequestParam(required = false, defaultValue = "")String nword) {
		
		Page<NoticeBoard> nlists = nService.nfindAll(nfield, nword, npageable);
		Long count = nService.count(nfield, nword);
		int currentPage= nlists.getPageable().getPageNumber();
		int countPage = nlists.getTotalPages();
        int startPage = Math.max(1, nlists.getPageable().getPageNumber() - 2);
        int endPage = Math.min(nlists.getPageable().getPageNumber()+3, nlists.getTotalPages());
 
        model.addAttribute("rowNo", count-(currentPage*countPage));
        model.addAttribute("currentPage", currentPage+1);
        model.addAttribute("countPage", countPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
		model.addAttribute("count", count);
		model.addAttribute("noticeboard", nlists);
		
		return "/noticeboard/noticeboard";
	}
	
	  @GetMapping("insert")
	  @PreAuthorize("isAuthenticated()")
	  public String insert() {
		  return "/noticeboard/noticeboardinsert";
	  }
	  
	  @PostMapping("insert")
	  public String insert(NoticeBoard nboard,  @AuthenticationPrincipal PrincipalUser principal) {
		  nService.insert(nboard, principal.getMember());
		  return "redirect:nboard";
	  }
	
	  @GetMapping("view/{nbnum}")
		public String view(@PathVariable Long nbnum, Model model) {
			model.addAttribute("nboard", nService.nviews(nbnum));
			return "/noticeboard/noticeboardview";
		}
	  
	  @DeleteMapping("delete/{nbnum}")
		@ResponseBody
		public String delete(@PathVariable Long nbnum) {
		  nService.delete(nbnum);
			return "success";
		}
	  
		@GetMapping("update/{nbnum}")
		public String update(@PathVariable Long nbnum, Model model) {
			model.addAttribute("nboard", nService.nviews(nbnum));
			return "/noticeboard/noticeboardupdate";
		}
		
		@PutMapping("update")
		@ResponseBody
		public String update(@RequestBody NoticeBoard noticeboard) {
			nService.update(noticeboard);
			return "success";
		}	  
	  
	  
	  
	  
}
