package com.example.tour.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tour.model.TourBoard;
import com.example.tour.service.FileService;


@Controller
public class FileController {
	@Autowired
	private FileService fileService;

	/*
	 * @GetMapping("insert") public String insert() { return "/tour/fileinsert"; }
	 * 
	 * @PostMapping("fileinsert") public String insert(TourBoard tboard,HttpSession
	 * session) { String uploadFolder
	 * =session.getServletContext().getRealPath("/")+"\\assets\\img";
	 * fileService.fileInsert(tboard, uploadFolder); return "redirect:list";
	 * 
	 * }
	 */
	@GetMapping("/file/list")
	public String list(Model model) {
		model.addAttribute("lists",fileService.list());
		
		return "/tour/gijang";
	}
	
	//상세보기
	@GetMapping("/tour/tourView/{tnum}")
	public String tourView(@PathVariable Long tnum, Model model) {
		model.addAttribute("tboard", fileService.findById(tnum));
		return "/tour/tourView";
	}
	}

