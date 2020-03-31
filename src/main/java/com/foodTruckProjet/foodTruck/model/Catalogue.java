package com.foodTruckProjet.foodTruck.model;

import java.util.ArrayList;
import java.util.List;

import com.foodTruckProjet.foodTruck.repo.ProduitRepository;
import com.foodTruckProjet.foodTruck.repo.TypeRepository;
import com.foodTruckProjet.foodTruck.repo.UtilisateurRepository;



public class Catalogue {

	private List<Produit> produits = new ArrayList<Produit>();
	
	private ProduitRepository prep;
	
	private TypeRepository trep;
	
	
	public Catalogue(ProduitRepository prepo, TypeRepository trepo)
	{
		this.prep=prepo;
		this.trep=trepo;
	}
	
	
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	public List<String> getFamille() {
		return prep.findAllfamille();
	}

	public List<Type> getType()
	{
		return trep.findAll();
	}

	public List<Produit> getProduits() {
		return produits;
	}

//	public List<Produit> getRecherche(String mot) {
//		return prep.findByNomLike(mot);
//	}
	
	public List<Produit> getPetitDejeuner()
	{
		
		return prep.findByType(trep.findByNom("Petit_Dejeuner"));
	}
	
	public List<Produit> getDejeuner()
	{
		return prep.findByType(trep.findByNom("Dejeuner"));
	}
	public List<Produit> getGouter()
	{
		return prep.findByType(trep.findByNom("Gouter"));
		
	}
	public List<Produit> getDiner()
	{
		return prep.findByType(trep.findByNom("Diner"));
		
	}
	
	public List<Produit> getBfroide()
	{
		return prep.findByFamille("boisson froide");
	}

	public List<Produit> getBchaude()
	{
		return prep.findByFamille("boisson chaude");
	}
	public List<Produit> getPlat()
	{
		return prep.findByFamille("plat");
	}

	public List<Produit> getEntr()
	{
		return prep.findByFamille("entree");
	}
	
	public List<Produit> getDessert()
	{
		return prep.findByFamille("dessert");
	}
}
