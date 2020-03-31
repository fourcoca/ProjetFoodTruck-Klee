package com.foodTruckProjet.foodTruck.model;


import java.util.ArrayList;
import java.util.List;

public class Panier {

	private ArrayList<Ligne> lignes = new ArrayList<Ligne>();

	public Panier()
	{
		
	}
	
	public ArrayList<Ligne> getLignes() {
		return lignes;
	}

	public void setLignes(ArrayList<Ligne> lignes) {
		this.lignes = lignes;
	}

	public void ajouterLigne(Ligne l)
	{
		boolean trouv = false;
		for (Ligne ligne : lignes) {
			if(ligne.getProduit().getNom().equals(l.getProduit().getNom()))
			{
				ligne.setQuantite(ligne.getQuantite()+l.getQuantite());
				trouv = true;
			}
		}
		if(!trouv)
		{
			this.lignes.add(l);
		}
	}
	
	public void ajouterQuantite(String produit,int q)
	{
		boolean trouv = false;
		for (Ligne ligne : lignes) {
			if(ligne.getProduit().getNom().equals(produit))
			{
				ligne.setQuantite(ligne.getQuantite()+q);
				if(ligne.getQuantite()>ligne.getProduit().getStock())
				{
					ligne.setQuantite(ligne.getProduit().getStock());
				}
				trouv = true;
			}
		}
		if(!trouv)
		{
			System.out.println("introuvable ligne à supprimer");
		}
	}
	
	public void diminuerQuantite(String produit,int q)
	{
		boolean trouv = false;
		Ligne asupp = null;
		for (Ligne ligne : lignes) {
			if(ligne.getProduit().getNom().equals(produit))
			{
				ligne.setQuantite(ligne.getQuantite()-q);
				if (ligne.getQuantite()<=0)
				{
					asupp=ligne;
				}
				trouv = true;
			}
		}
		if(!trouv)
		{
			System.out.println("introuvable ligne à supprimer");
		}
		if(asupp!=null)
		{
			this.lignes.remove(asupp);
		}
	}
	
	public void supprimerLigne(String produit)
	{
		boolean trouv = false;
		Ligne asuppr = new Ligne();
		for (Ligne ligne : lignes) {
			if(ligne.getProduit().getNom().equals(produit))
			{
				asuppr=ligne;
				trouv = true;
			}
		}
		this.lignes.remove(asuppr);
		if(!trouv)
		{
			System.out.println("introuvable ligne à supprimer");
		}
	}
	
	
	public double getPrixTotal() {
		double total = 0;
		for (Ligne ligne : lignes) {
			total += ligne.getPrix();
		}
		return total;
	}
}
