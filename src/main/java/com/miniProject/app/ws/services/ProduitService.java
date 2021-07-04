package com.miniProject.app.ws.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniProject.app.ws.entities.Produit;
import com.miniProject.app.ws.repositories.IProductRepository;
@Service
public class ProduitService implements IProduitService {
	@Autowired
	IProductRepository iproductrepository;

	@Override
	public Produit FindByIdProduit(Long id) {
		Optional<Produit> produit = iproductrepository.findById(id);
		if(produit.isPresent())
			return produit.get();
		return null;
	}

	@Override
	public Produit AjoutProduit(Produit p) {
		if(p.getQuantite()>0) {
			p.setDisponible(true);
		}
		return iproductrepository.save(p);
	}

	@Override
	public Produit SupprimerProduit(Long id) {
		Optional<Produit> produit = iproductrepository.findById(id);
		if (produit.isPresent()){
			iproductrepository.delete(produit.get());
			return produit.get();
		}
		return null;

	}

	@Override
	public Produit ModifierProduit(Produit p) {
		return iproductrepository.save(p);
		
	}

	@Override
	public List<Produit> GetAllProduitsByCategorieId(Long id) {
		return iproductrepository.GetAllProduitsByCategorieId(id);
	}

	
}
