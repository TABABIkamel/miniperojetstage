package com.miniProject.app.ws.entities;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
public class Produit  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private int quantite;
	private boolean disponible; 
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
    private Timestamp regdate;
    @UpdateTimestamp
	@Column(nullable = true, updatable = true)
    private Timestamp updatedate;
    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    private Categorie categorie;
    
   
	public Produit() {
		super();
	}
	public Produit(Long id, String nom, int quantite, boolean disponible, Timestamp regdate, Timestamp updatedate) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.disponible = disponible;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}

    
    
}
