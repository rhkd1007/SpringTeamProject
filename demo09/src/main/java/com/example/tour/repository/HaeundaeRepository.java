package com.example.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tour.model.Gangseo;
import com.example.tour.model.Haeundae;
import com.example.tour.model.Namgu;

public interface HaeundaeRepository extends JpaRepository<Haeundae, Long> {

}
