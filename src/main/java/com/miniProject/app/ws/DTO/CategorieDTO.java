package com.miniProject.app.ws.DTO;



import java.sql.Timestamp;

public class CategorieDTO {
    private Long id;
    private String nomCategorie;
    private int quantiteCategorie=0;
    private Timestamp adddateCategorie;
    private Timestamp updatedateCategorie;

    public CategorieDTO(Long id, String nomCategorie, int quantiteCategorie, Timestamp adddateCategorie, Timestamp updatedateCategorie) {
        this.id = id;
        this.nomCategorie = nomCategorie;
        this.quantiteCategorie = quantiteCategorie;
        this.adddateCategorie = adddateCategorie;
        this.updatedateCategorie = updatedateCategorie;
    }

    public CategorieDTO() {
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public int getQuantiteCategorie() {
        return quantiteCategorie;
    }

    public void setQuantiteCategorie(int quantiteCategorie) {
        this.quantiteCategorie = quantiteCategorie;
    }

    public Timestamp getAdddateCategorie() {
        return adddateCategorie;
    }

    public void setAdddateCategorie(Timestamp adddateCategorie) {
        this.adddateCategorie = adddateCategorie;
    }

    public Timestamp getUpdatedateCategorie() {
        return updatedateCategorie;
    }

    public void setUpdatedateCategorie(Timestamp updatedateCategorie) {
        this.updatedateCategorie = updatedateCategorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
