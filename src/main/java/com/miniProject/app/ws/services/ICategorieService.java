package com.miniProject.app.ws.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.miniProject.app.ws.entities.Categorie;

public interface ICategorieService {
	public Categorie AjoutCategorie(Categorie c); 
	public Categorie SupprimerCategorie(Long id);
	public List<Categorie> GetAllCategorie();
	public Categorie ModifierCategorie(Categorie c);
	public void affecterProductACategorie(Long prodId, Long categId);

}
