package com.miniProject.app.ws.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miniProject.app.ws.entities.Produit;


@Repository
public interface IProductRepository extends CrudRepository<Produit,Long> {
	@Query("SELECT p FROM Produit p WHERE p.categorie.id=:id")
	List<Produit> GetAllProduitsByCategorieId(@Param("id")Long id);
	

}
