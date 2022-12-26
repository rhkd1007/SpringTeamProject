package com.example.tour.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
import com.example.tour.repository.BukguRepository;
import com.example.tour.repository.DongguRepository;
import com.example.tour.repository.DongraeRepository;
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

@Service
public class TourService {
	@Autowired
	private TourRepository tourRepository;
	@Autowired
	private BukguRepository bukguRepository;
	@Autowired
	private DongguRepository dongguRepository;
	@Autowired
	private GangseoRepository gangseoRepository;
	@Autowired
	private JinguRepository jinguRepository;
	@Autowired
	private JungguRepository jungguRepository;
	@Autowired
	private SahaRepository sahaRepository;
	@Autowired
	private SasangRepository sasangRepository;
	@Autowired
	private SeoguRepository seoguRepository;
	@Autowired
	private NamguRepository namguRepository;
	@Autowired
	private YoungdoRepository youngdoRepository;
	@Autowired
	private SuyoungRepository suyoungRepository;
	@Autowired
	private YeonjeRepository yeonjeRepository;
	@Autowired
	private DongraeRepository dongraeRepository;
	@Autowired
	private GeomjungRepository geomjungRepository;
	@Autowired
	private HaeundaeRepository haeundaeRepository;
	
	//기장
	public void save(TourDTO tourDto) {
		tourRepository.save(tourDto);
	}
	public Page<TourDTO> list(Pageable pageable){
		return tourRepository.findAll(pageable);
	}

	public long count() {
		return  tourRepository.count();
	}
	
	//북구
	public void bukgusave(Bukgu tourDto) {
		bukguRepository.save(tourDto);
	}
	public Page<Bukgu> bukgu(Pageable pageable){
		return bukguRepository.findAll(pageable);
	}

	public long bukgucount() {
		return  bukguRepository.count();
	}
	
	//동구
	public void donggusave(Donggu tourDto) {
		dongguRepository.save(tourDto);
	}
	public Page<Donggu> donggu(Pageable pageable){
		return dongguRepository.findAll(pageable);
	}

	public long donggucount() {
		return  dongguRepository.count();
	}
	
	//강서구
	public void gangseosave(Gangseo tourDto) {
		gangseoRepository.save(tourDto);
	}
	public Page<Gangseo> gangseo(Pageable pageable){
		return gangseoRepository.findAll(pageable);
	}

	public long gangseocount() {
		return  gangseoRepository.count();
	}
	
	//진구
	public void jingusave(Jingu tourDto) {
		jinguRepository.save(tourDto);
	}
	public Page<Jingu> jingu(Pageable pageable){
		return jinguRepository.findAll(pageable);
	}

	public long jingucount() {
		return  jinguRepository.count();
	}
	
	//중구
	public void junggusave(Junggu tourDto) {
		jungguRepository.save(tourDto);
	}
	public Page<Junggu> junggu(Pageable pageable){
		return jungguRepository.findAll(pageable);
	}

	public long junggucount() {
		return  jungguRepository.count();
	}
	
	//사하구
	public void sahasave(Saha tourDto) {
		sahaRepository.save(tourDto);
	}
	public Page<Saha> saha(Pageable pageable){
		return sahaRepository.findAll(pageable);
	}

	public long sahacount() {
		return  sahaRepository.count();
	}
	
	//사상구
	public void sasangsave(Sasang tourDto) {
		sasangRepository.save(tourDto);
	}
	public Page<Sasang> sasang(Pageable pageable){
		return sasangRepository.findAll(pageable);
	}

	public long sasangcount() {
		return  sasangRepository.count();
	}
	
	//서구
	public void seogusave(Seogu tourDto) {
		seoguRepository.save(tourDto);
	}
	public Page<Seogu> seogu(Pageable pageable){
		return seoguRepository.findAll(pageable);
	}

	public long seogucount() {
		return  seoguRepository.count();
	}
	
	//남구
	public void namgusave(Namgu tourDto) {
		namguRepository.save(tourDto);
	}
	public Page<Namgu> namgu(Pageable pageable){
		return namguRepository.findAll(pageable);
	}

	public long namgucount() {
		return  namguRepository.count();
	}
	
	//영도구
	public void youngdosave(Youngdo tourDto) {
		youngdoRepository.save(tourDto);
	}
	public Page<Youngdo> youngdo(Pageable pageable){
		return youngdoRepository.findAll(pageable);
	}

	public long youngdocount() {
		return  youngdoRepository.count();
	}
	
	//수영구
	public void suyoungsave(Suyoung tourDto) {
		suyoungRepository.save(tourDto);
	}
	public Page<Suyoung> suyoung(Pageable pageable){
		return suyoungRepository.findAll(pageable);
	}

	public long suyoungcount() {
		return  suyoungRepository.count();
	}
	
	//연제구
	public void yeonjesave(Yeonje tourDto) {
		yeonjeRepository.save(tourDto);
	}
	public Page<Yeonje> yeonje(Pageable pageable){
		return yeonjeRepository.findAll(pageable);
	}

	public long yeonjecount() {
		return  yeonjeRepository.count();
	}
	
	//동래구
	public void dongraesave(Dongrae tourDto) {
		dongraeRepository.save(tourDto);
	}
	public Page<Dongrae> dongrae(Pageable pageable){
		return dongraeRepository.findAll(pageable);
	}

	public long dongraecount() {
		return  dongraeRepository.count();
	}

		
	//금정구
	public void geomjungsave(Geomjung tourDto) {
		geomjungRepository.save(tourDto);
	}
	public Page<Geomjung> geomjung(Pageable pageable){
		return geomjungRepository.findAll(pageable);
	}

	public long geomjungcount() {
		return  geomjungRepository.count();
	}
	
	//해운대구
	public void haeundaesave(Haeundae tourDto) {
		haeundaeRepository.save(tourDto);
	}
	public Page<Haeundae> haeundae(Pageable pageable){
		return haeundaeRepository.findAll(pageable);
	}

	public long haeundaecount() {
		return  haeundaeRepository.count();
	}
}
