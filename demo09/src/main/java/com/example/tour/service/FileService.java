package com.example.tour.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import com.example.tour.model.TourBoard;
import com.example.tour.repository.FileRepository;

@Service
public class FileService {
	@Autowired
	private FileRepository fileRepository;

	/*
	 * public void fileInsert(TourBoard tboard, String uploadFolder) { UUID uuid
	 * =UUID.randomUUID(); MultipartFile f = tboard.getUpload(); String
	 * uploadFileName=""; if(!f.isEmpty()) {//?åå?ùº?Ñ†?Éù?ê®
	 * uploadFileName=uuid.toString()+"_"+f.getOriginalFilename(); File saveFile
	 * =new File(uploadFolder,uploadFileName); try { f.transferTo(saveFile);
	 * tboard.setTfilename(uploadFileName); } catch (IllegalStateException |
	 * IOException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * }//?åå?ùº ?óÖÎ°úÎìú } fileRepository.save(tboard); }
	 */
public List<TourBoard> list(){
	return fileRepository.findAll();
}

public TourBoard findById(Long tnum) {
	return fileRepository.findById(tnum).get();

}
}


