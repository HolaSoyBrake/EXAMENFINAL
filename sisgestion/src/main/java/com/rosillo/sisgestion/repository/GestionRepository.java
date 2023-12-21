package com.rosillo.sisgestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rosillo.sisgestion.entity.Gestion;

@Repository
public interface GestionRepository  extends JpaRepository<Gestion, Integer>{
	List<Gestion> findByDniContaining(String dni);
	Gestion findByDni(String dni);
}
