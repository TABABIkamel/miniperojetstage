package com.miniProject.app.ws.DTO;
import java.sql.Timestamp;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public boolean isDisp() {
        return disp;
    }

    public void setDisp(boolean disp) {
        this.disp = disp;
    }

    public Timestamp getAjoutdate() {
        return ajoutdate;
    }

    public void setAjoutdate(Timestamp ajoutdate) {
        this.ajoutdate = ajoutdate;
    }

    public Timestamp getModifdate() {
        return modifdate;
    }

    public void setModifdate(Timestamp modifdate) {
        this.modifdate = modifdate;
    }
}
