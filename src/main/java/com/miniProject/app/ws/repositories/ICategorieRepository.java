package com.miniProject.app.ws.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miniProject.app.ws.entities.Categorie;

import java.util.Optional;

@Repository
public interface ICategorieRepository extends CrudRepository<Categorie,Long> {
}
