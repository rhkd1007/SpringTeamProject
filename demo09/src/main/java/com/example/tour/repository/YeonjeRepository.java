package com.example.tour.repository;

import java.security.cert.CertPathBuilder;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tour.model.Donggu;
import com.example.tour.model.Saha;
import com.example.tour.model.Sasang;
import com.example.tour.model.Seogu;
import com.example.tour.model.TourDTO;
import com.example.tour.model.Yeonje;
import com.example.tour.model.Youngdo;

public interface YeonjeRepository extends JpaRepository<Yeonje, Long> {

}

