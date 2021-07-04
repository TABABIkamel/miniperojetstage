package com.miniProject.app.ws.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.miniProject.app.ws.DTO.ProduitDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniProject.app.ws.controllers.export.ExportExcel;
import com.miniProject.app.ws.controllers.export.ExportPdf;
import com.miniProject.app.ws.entities.Produit;
import com.miniProject.app.ws.services.IProduitService;

@RestController
@RequestMapping("/Product")
public class ProductController {
	@Autowired
	IProduitService prodServ;
	@GetMapping("/getProductById/{id}")
	public Produit FindByIdProduit(@PathVariable("id")Long id) {
		return prodServ.FindByIdProduit(id);
	}
	@PostMapping("/ajout-produit")
	@CrossOrigin(origins = "http://localhost:4200")
	public Produit AjoutProduit(@RequestBody ProduitDTO produitDTO) {
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new PropertyMap<ProduitDTO, Produit>() {
			protected void configure(){
				map().setNom(source.getName());
				map().setQuantite(source.getQt());
				map().setDisponible(source.isDisp());
				map().setRegdate(source.getAjoutdate());
				map().setUpdatedate(source.getModifdate());
			}
		});
		return prodServ.AjoutProduit(mapper.map(produitDTO,Produit.class));
	}
	@DeleteMapping("/supprimer-produit/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Produit SupprimerProduit(@PathVariable("id")Long id) {
		return prodServ.SupprimerProduit(id);	
	}
	@PutMapping("/modifier-produit")
	public Produit ModifierProduit(@RequestBody ProduitDTO produitDTO) {
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new PropertyMap<ProduitDTO, Produit>() {
			protected void configure(){
				map().setId(source.getId());
				map().setNom(source.getName());
				map().setQuantite(source.getQt());
				map().setDisponible(source.isDisp());
				map().setRegdate(source.getAjoutdate());
				map().setUpdatedate(source.getModifdate());
			}
		});
		return prodServ.ModifierProduit(mapper.map(produitDTO,Produit.class));
	}
	@GetMapping("/GetAllProduitsByCategorieId/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Produit> GetAllProduitsByCategorieId(@PathVariable("id")Long id) {
		return prodServ.GetAllProduitsByCategorieId(id);
	}
	
	@GetMapping(value = "/exportpdf/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response,@PathVariable("id")Long id) throws IOException {

		List<Produit> allProduitPerCategorie = prodServ.GetAllProduitsByCategorieId(id);

		ByteArrayInputStream bis = ExportPdf.produitsReport(allProduitPerCategorie);

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", "attachment;filename=produits.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	@GetMapping("/exportexcel/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
    public void exportToExcel(HttpServletResponse response,@PathVariable("id")Long id) throws IOException {
        response.setContentType("application/octet-stream");
        //DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        //String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=produits.xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<Produit> listProduit = prodServ.GetAllProduitsByCategorieId(id);
         
        ExportExcel excelExporter = new ExportExcel(listProduit);
         
        excelExporter.export(response);  
        
    }  
	
	
	
	

}
