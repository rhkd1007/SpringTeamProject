package com.example.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tour.model.Gangseo;
import com.example.tour.model.Namgu;

public interface NamguRepository extends JpaRepository<Namgu, Long> {

}
