package com.rosillo.sisgestion.service;

import java.util.List;

import com.rosillo.sisgestion.entity.Gestion;

public interface GestionService {
	public List<Gestion> findAll();
	public Gestion findById(int id);
	public Gestion findByDni(String dni);
	public Gestion create(Gestion obj);
	public Gestion update(Gestion obj);
	public int delete(int id);
}
