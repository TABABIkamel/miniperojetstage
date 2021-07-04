package com.miniProject.app.ws.controllers;

import java.util.List;


import com.miniProject.app.ws.DTO.CategorieDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniProject.app.ws.entities.Categorie;
import com.miniProject.app.ws.services.ICategorieService;
@RestController
@RequestMapping("/Categorie")

public class CategorieController {
	@Autowired
	ICategorieService icategorieservice;

	@PostMapping("/ajout-categorie")
	@CrossOrigin(origins = "http://localhost:4200")
	public Categorie AjoutCategorie(@RequestBody CategorieDTO categorieDTO) {
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new PropertyMap<CategorieDTO, Categorie>() {
			protected void configure(){
				map().setNom(source.getNomCategorie());
				map().setQuantite(source.getQuantiteCategorie());
				map().setRegdate(source.getAdddateCategorie());
				map().setUpdatedate(source.getUpdatedateCategorie());
			}
		});
		return icategorieservice.AjoutCategorie(mapper.map(categorieDTO,Categorie.class));
	}
	@DeleteMapping("/supprimer-categorie/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Categorie SupprimerCategorie(@PathVariable("id")Long id) {
		return icategorieservice.SupprimerCategorie(id);
	}
	
	@PutMapping("/modifier-categorie")
	@CrossOrigin(origins = "http://localhost:4200")
	public Categorie ModifierCategorie(@RequestBody CategorieDTO categorieDTO) {
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new PropertyMap<CategorieDTO, Categorie>() {
			protected void configure(){
				map().setId(source.getId());
				map().setNom(source.getNomCategorie());
				map().setQuantite(source.getQuantiteCategorie());
				map().setRegdate(source.getAdddateCategorie());
				map().setUpdatedate(source.getUpdatedateCategorie());
			}
		});

		return icategorieservice.ModifierCategorie(mapper.map(categorieDTO,Categorie.class));
	}
	
	@PutMapping("/affecte-product-categorie/{idProd}/{idCat}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void affecterProductACategorie(@PathVariable("idProd")Long idProd,@PathVariable("idCat")Long idCat) {
		icategorieservice.affecterProductACategorie(idProd, idCat);
	}
	
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Categorie> GetAllCategorie(){
		return icategorieservice.GetAllCategorie();
	}
	
	
	
	
	
	
}
