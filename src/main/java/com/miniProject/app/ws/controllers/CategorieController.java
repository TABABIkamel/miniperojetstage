package com.miniProject.app.ws.controllers;

import java.util.List;


import com.miniProject.app.ws.DTO.CategorieDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.miniProject.app.ws.entities.Categorie;
import com.miniProject.app.ws.services.ICategorieService;
@RestController
@RequestMapping("/Categorie")
@AllArgsConstructor
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
