package com.example.tour.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.json.XML;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tour.model.Bukgu;
import com.example.tour.model.Donggu;
import com.example.tour.model.Dongrae;
import com.example.tour.model.Gangseo;
import com.example.tour.model.Geomjung;
import com.example.tour.model.Haeundae;
import com.example.tour.model.Jingu;
import com.example.tour.model.Junggu;
import com.example.tour.model.Namgu;
import com.example.tour.model.Saha;
import com.example.tour.model.Sasang;
import com.example.tour.model.Seogu;
import com.example.tour.model.Suyoung;
import com.example.tour.model.TourDTO;
import com.example.tour.model.Yeonje;
import com.example.tour.model.Youngdo;
import com.example.tour.service.TourService;


@Controller
@RequestMapping("/tour/*")
public class RegionController {
	@Autowired
	private TourService tourService;
	
	@GetMapping("gijang")
	public String gijanghome(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EA%B8%B0%EC%9E%A5%EA%B5%B0";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");   
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	TourDTO tourDto = new TourDTO(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.save(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.count();
			Page<TourDTO> lists= tourService.list(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();


			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("count", count);
			model.addAttribute("barr",lists);
		return "/tour/gijang";
	}
	
	@GetMapping("gangseo")
	public String gangseo(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EB%B6%80%EC%82%B0%20%EA%B0%95%EC%84%9C%EA%B5%AC";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");   
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Gangseo tourDto = new Gangseo(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.gangseosave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.gangseocount();
			Page<Gangseo> lists= tourService.gangseo(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("gangseo",lists);
		return "/tour/gangseo";
	}
	@GetMapping("saha")
	public String saha(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EC%82%AC%ED%95%98%EA%B5%AC";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");   
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Saha tourDto = new Saha(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.sahasave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.sahacount();
			Page<Saha> lists= tourService.saha(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("saha",lists);
		return "/tour/saha";
	}
	@GetMapping("seogu")
	public String seogu(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EB%B6%80%EC%82%B0%20%EC%84%9C%EA%B5%AC";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");  
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Seogu tourDto = new Seogu(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.seogusave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.seogucount();
			Page<Seogu> lists= tourService.seogu(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("seogu",lists);
		return "/tour/seogu";
	}
	@GetMapping("junggu")
	public String junggu(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EB%B6%80%EC%82%B0%20%EC%A4%91%EA%B5%AC";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");  
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Junggu tourDto = new Junggu(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.junggusave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.junggucount();
			Page<Junggu> lists= tourService.junggu(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("junggu",lists);
		return "/tour/junggu";
	}
	@GetMapping("sasang")
	public String sasang(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EC%82%AC%EC%83%81%EA%B5%AC";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");  
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Sasang tourDto = new Sasang(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.sasangsave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.sasangcount();
			Page<Sasang> lists= tourService.sasang(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("sasang",lists);
		return "/tour/sasang";
	}
	@GetMapping("bukgu")
	public String bukgu(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EB%B6%80%EC%82%B0%20%EB%B6%81%EA%B5%AC";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");  
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Bukgu tourDto = new Bukgu(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.bukgusave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.bukgucount();
			Page<Bukgu> lists= tourService.bukgu(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("bukgu",lists);
		return "/tour/bukgu";
	}
	@GetMapping("jingu")
	public String jingu(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EB%B6%80%EC%82%B0%20%EC%A7%84%EA%B5%AC";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");  
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Jingu tourDto = new Jingu(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.jingusave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.jingucount();
			Page<Jingu> lists= tourService.jingu(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("jingu",lists);
		return "/tour/jingu";
	}
	
	@GetMapping("namgu")
	public String namgu(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EB%B6%80%EC%82%B0%20%EB%82%A8%EA%B5%AC";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");  
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Namgu tourDto = new Namgu(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.namgusave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.namgucount();
			Page<Namgu> lists= tourService.namgu(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("namgu",lists);
		return "/tour/namgu";
	}
	@GetMapping("youngdo")
	public String youngdo(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EB%B6%80%EC%82%B0%20%EC%98%81%EB%8F%84";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");  
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Youngdo tourDto = new Youngdo(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.youngdosave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.youngdocount();
			Page<Youngdo> lists= tourService.youngdo(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("youngdo",lists);
		return "/tour/youngdo";
	}
	@GetMapping("suyoung")
	public String suyoung(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EB%B6%80%EC%82%B0%20%EC%88%98%EC%98%81%EA%B5%AC";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");  
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Suyoung tourDto = new Suyoung(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.suyoungsave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.suyoungcount();
			Page<Suyoung> lists= tourService.suyoung(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("suyoung",lists);
		return "/tour/suyoung";
	}
	@GetMapping("donggu")
	public String donggu(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EB%B6%80%EC%82%B0%20%EB%8F%99%EA%B5%AC";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");  
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Donggu tourDto = new Donggu(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.donggusave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.donggucount();
			Page<Donggu> lists= tourService.donggu(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("donggu",lists);
		return "/tour/donggu";}
		@GetMapping("yeonje")
		public String yeonje(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
			 StringBuffer result = new StringBuffer();
		        String jsonPrintString = null;
		        String returnLine = "";
		        int currentPage = page==null? 1: Integer.parseInt(page); 
				int pageSize = 5;
				try {
					String apiUrl=
							"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
							+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
							+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
							+ "&keyword=%EB%B6%80%EC%82%B0%20%EC%97%B0%EC%A0%9C";
					   URL url = new URL(apiUrl);
			            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			            urlConnection.connect();
			            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
			            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
			          
			            while((returnLine = bufferedReader.readLine()) != null) {
			                result.append(returnLine);	            	
			            }

			           JSONObject jsonObject = XML.toJSONObject(result.toString());

			            jsonPrintString = jsonObject.toString();
			            JSONObject rObject= jsonObject.getJSONObject("response");  
			            JSONObject bObject= rObject.getJSONObject("body");
			            JSONObject sObject= bObject.getJSONObject("items");
			            JSONArray jsonArray = (JSONArray)sObject.get("item");
			            
			            for(int i=0; i<jsonArray.length();i++) {
			            	JSONObject object=(JSONObject) jsonArray.get(i);
			            	Long galContentId = ((Number) object.get("galContentId")).longValue();
			            	String galTitle = (String) object.get("galTitle");
			            	String galWebImageUrl = (String) object.get("galWebImageUrl");
			            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
			            	Yeonje tourDto = new Yeonje(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
			            	tourService.yeonjesave(tourDto);
			            }


			        } catch (Exception e) {
			            e.printStackTrace();
			        }
				long count = tourService.yeonjecount();
				Page<Yeonje> lists= tourService.yeonje(pageable);

				 int currentpage= lists.getPageable().getPageNumber();
				 int countpge = lists.getTotalPages();

				 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
			        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
			        model.addAttribute("countpge",countpge);
			        model.addAttribute("currentpage", currentpage+1);
			      model.addAttribute("startPage", startPage);
			        model.addAttribute("endPage", endPage);
				model.addAttribute("gcount", count);
				model.addAttribute("yeonje",lists);
			return "/tour/yeonje";
	}
	@GetMapping("dongrae")
	public String dongrae(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EB%B6%80%EC%82%B0%20%EB%8F%99%EB%9E%98%EA%B5%AC";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");  
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Dongrae tourDto = new Dongrae(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.dongraesave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.dongraecount();
			Page<Dongrae> lists= tourService.dongrae(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("dongrae",lists);
		return "/tour/dongrae";
	}
	@GetMapping("geomjung")
	public String geomjung(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EB%B6%80%EC%82%B0%20%EA%B8%88%EC%A0%95%EA%B5%AC";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");  
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Geomjung tourDto = new Geomjung(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.geomjungsave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.geomjungcount();
			Page<Geomjung> lists= tourService.geomjung(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("geomjung",lists);
		return "/tour/geomjung";
	}
	@GetMapping("haeundae")
	public String haeundae(Model model,String page,@PageableDefault(size = 4, sort = "galContentId") Pageable pageable) {
		 StringBuffer result = new StringBuffer();
	        String jsonPrintString = null;
	        String returnLine = "";
	        int currentPage = page==null? 1: Integer.parseInt(page); 
			int pageSize = 5;
			try {
				String apiUrl=
						"http://apis.data.go.kr/B551011/PhotoGalleryService/gallerySearchList?"
						+ "serviceKey=sbWRE%2BUbAvdhJqSakNRDX4lfFEj0mNeAbM9Sg7LO%2BOw2cjETA7GTl%2B7vg47xT72J1NELgtakZnMNHcOPC7TzwA%3D%3D"
						+ "&numOfRows=42&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A"
						+ "&keyword=%EB%B6%80%EC%82%B0%20%ED%95%B4%EC%9A%B4%EB%8C%80%EA%B5%AC";
				   URL url = new URL(apiUrl);
		            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		            urlConnection.connect();
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
		          
		            while((returnLine = bufferedReader.readLine()) != null) {
		                result.append(returnLine);	            	
		            }

		           JSONObject jsonObject = XML.toJSONObject(result.toString());

		            jsonPrintString = jsonObject.toString();
		            JSONObject rObject= jsonObject.getJSONObject("response");  
		            JSONObject bObject= rObject.getJSONObject("body");
		            JSONObject sObject= bObject.getJSONObject("items");
		            JSONArray jsonArray = (JSONArray)sObject.get("item");
		            
		            for(int i=0; i<jsonArray.length();i++) {
		            	JSONObject object=(JSONObject) jsonArray.get(i);
		            	Long galContentId = ((Number) object.get("galContentId")).longValue();
		            	String galTitle = (String) object.get("galTitle");
		            	String galWebImageUrl = (String) object.get("galWebImageUrl");
		            	String galPhotographyLocation = (String) object.get("galPhotographyLocation");
		            	Haeundae tourDto = new Haeundae(galContentId,galTitle,galWebImageUrl,galPhotographyLocation);
		            	tourService.haeundaesave(tourDto);
		            }


		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			long count = tourService.haeundaecount();
			Page<Haeundae> lists= tourService.haeundae(pageable);

			 int currentpage= lists.getPageable().getPageNumber();
			 int countpge = lists.getTotalPages();

			 int startPage = Math.max(1, lists.getPageable().getPageNumber() - 2);
		        int endPage = Math.min(lists.getPageable().getPageNumber()+2, lists.getTotalPages());
		        model.addAttribute("countpge",countpge);
		        model.addAttribute("currentpage", currentpage+1);
		      model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
			model.addAttribute("gcount", count);
			model.addAttribute("haeundae",lists);
		return "/tour/haeundae";
	}
	
}
