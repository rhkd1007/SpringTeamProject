package com.example.tour.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tour.model.Saha;
import com.example.tour.model.TourDTO;

public interface SahaRepository extends JpaRepository<Saha, Long> {
	
	
}

