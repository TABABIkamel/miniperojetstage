package com.miniProject.app.ws;

import com.miniProject.app.ws.entities.Categorie;
import com.miniProject.app.ws.services.ICategorieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorieTest {
    @Autowired
    ICategorieService icategorieservice;
    @Test
    public void TestGetAllCategorie() {
        icategorieservice.GetAllCategorie();
    }
    @Test
    public void TestAjoutCategorie() {
        var categorie = new Categorie("cat1",40);
        icategorieservice.AjoutCategorie(categorie);
    }
    //@Test
    //public void TestSupprimerCategorie() {
      //  icategorieservice.SupprimerCategorie(18L);
    //}
}
