package com.example.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tour.model.Gangseo;
import com.example.tour.model.Junggu;
import com.example.tour.model.Suyoung;

public interface SuyoungRepository extends JpaRepository<Suyoung, Long> {

}
