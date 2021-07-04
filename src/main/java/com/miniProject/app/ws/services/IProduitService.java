package com.miniProject.app.ws.services;

import java.util.List;

import com.miniProject.app.ws.entities.Produit;

public interface IProduitService {
	public Produit FindByIdProduit(Long id);
	public Produit AjoutProduit(Produit p); 
	public Produit SupprimerProduit(Long id);
	public Produit ModifierProduit(Produit p);
	public List<Produit> GetAllProduitsByCategorieId(Long id);

}
