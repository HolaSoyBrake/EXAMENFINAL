package com.rosillo.sisgestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rosillo.sisgestion.entity.Gestion;
import com.rosillo.sisgestion.service.impl.GestionServiceImpl;

@RestController
@RequestMapping("/api/gestion")

public class GestionController {
	@Autowired
	private GestionServiceImpl Service;
	//localhost:8091/api/categorias (GET)
	@GetMapping() 
	public ResponseEntity<List<Gestion>> getAll(){
		List<Gestion> gestion= Service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(gestion);
	}
	//localhost:8091/api/categorias/1 (GET)
		@GetMapping(value="/{id}") 
		public ResponseEntity<Gestion> getById(@PathVariable("id") int id) {
			Gestion gestion = Service.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(gestion);
	}
		//localhost:8091/api/categorias (POST)
		@PostMapping 
		public ResponseEntity<Gestion> create(@RequestBody Gestion gestion) {
			Gestion gestionDb=Service.create(gestion);
			return ResponseEntity.status(HttpStatus.CREATED).body(gestionDb);
	}	
		//localhost:8091/api/categorias/1 (PUT)
		@PutMapping
		public ResponseEntity<Gestion> update(@RequestBody Gestion gestion) {
			Gestion gestionDb=Service.update(gestion);
			return ResponseEntity.status(HttpStatus.OK).body(gestionDb);
		}
		//localhost:8091/api/categorias/1 (DELETE)
		@DeleteMapping(value="/{id}")
		public int delete(@PathVariable("id") int id){
			return Service.delete(id);
		}

}
