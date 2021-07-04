package com.miniProject.app.ws.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniProject.app.ws.entities.Categorie;
import com.miniProject.app.ws.entities.Produit;
import com.miniProject.app.ws.repositories.ICategorieRepository;
import com.miniProject.app.ws.repositories.IProductRepository;
@Service
public class CategorieService implements ICategorieService{
	@Autowired
	ICategorieRepository icategorierepository;
	@Autowired
	IProductRepository iproductrepository;
	@Override
	public Categorie AjoutCategorie(Categorie c) {
		
		return icategorierepository.save(c);
	}

	@Override
	public Categorie SupprimerCategorie(Long id) {
		Optional<Categorie> categorie= icategorierepository.findById(id);
		if(categorie.isPresent()){
			icategorierepository.delete(categorie.get());
		}
		if (categorie.isPresent())
			return categorie.get();
		return null;
	}

	@Override
	public Categorie ModifierCategorie (Categorie c) {
		return icategorierepository.save(c);
			
	}

	@Override
	public void affecterProductACategorie (Long prodId, Long categId) {
		 Optional<Categorie> categorie=icategorierepository.findById(categId);
		 Optional<Produit> produit =  iproductrepository.findById(prodId);
		 if (categorie.isPresent() && produit.isPresent() ) {
			 produit.get().setCategorie(categorie.get());
		 }
		 if(produit.isPresent()){
			 iproductrepository.save(produit.get());
		 }

	}

	@Override
	public List<Categorie> GetAllCategorie() {
		return (List<Categorie>) icategorierepository.findAll();
	}

}
