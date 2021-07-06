package com.miniProject.app.ws.DTO;



import lombok.Data;

import java.sql.Timestamp;
@Data
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

}
