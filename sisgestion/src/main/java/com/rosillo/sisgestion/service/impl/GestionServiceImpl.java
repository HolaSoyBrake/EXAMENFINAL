package com.rosillo.sisgestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rosillo.sisgestion.repository.GestionRepository;
import com.rosillo.sisgestion.entity.Gestion;
import com.rosillo.sisgestion.service.GestionService;



@Service
public class GestionServiceImpl implements GestionService{

	@Autowired
	private GestionRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Gestion> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Gestion findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Gestion findByDni(String dni) {
		try {
			return repository.findByDni(dni);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public Gestion create(Gestion obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public Gestion update(Gestion obj) {
		try {
			Gestion GestionDb=repository.findById(obj.getId()).orElse(null);
			if(GestionDb==null) {
				return null;
			}
			GestionDb.setDni(obj.getDni());
			return repository.save(GestionDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Gestion GestionDb=repository.findById(id).orElse(null);
			if(GestionDb==null) {
				return 0;
			}else {
				repository.delete(GestionDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}

}
