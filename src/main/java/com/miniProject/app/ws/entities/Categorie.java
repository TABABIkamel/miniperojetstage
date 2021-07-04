package com.miniProject.app.ws.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private int quantite=0;
	@CreationTimestamp
    private Timestamp regdate;
    @UpdateTimestamp
    private Timestamp updatedate;
    @JsonIgnore
    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="categorie")
    private Set<Produit> produit;
    
	public Categorie() {
		super();
	}
	public Categorie(Long id, String nom, int quantite, Timestamp regdate, Timestamp updatedate) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}

	public Categorie(String nom, int quantite) {
		this.nom = nom;
		this.quantite = quantite;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	public Set<Produit> getProduit() {
		return produit;
	}
	public void setProduit(Set<Produit> produit) {
		this.produit = produit;
	}
	
	
	

}
