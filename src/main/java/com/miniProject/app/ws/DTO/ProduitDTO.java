package com.miniProject.app.ws.DTO;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class ProduitDTO {
    private Long id;
    private String name;
    private int qt;
    private boolean disp;
    private Timestamp ajoutdate;
    private Timestamp modifdate;

    public ProduitDTO(Long id, String name, int qt, boolean disp, Timestamp ajoutdate, Timestamp modifdate) {
        this.id = id;
        this.name = name;
        this.qt = qt;
        this.disp = disp;
        this.ajoutdate = ajoutdate;
        this.modifdate = modifdate;
    }

    public ProduitDTO() {
    }

}
