package com.foodTruckProjet.foodTruck.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Ligne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int quantite;
	private String statut;
	private LocalDateTime dateDeLivraison;
	private String adresse;
	
	@ManyToOne
	private Produit produit;
	
	public Ligne()
	{
		
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	

	public LocalDateTime getDateDeLivraison() {
		return dateDeLivraison;
	}

	public void setDateDeLivraison(LocalDateTime dateDeLivraison) {
		this.dateDeLivraison = dateDeLivraison;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Ligne(int quantite, String statut, LocalDateTime date, String adresse, Produit produit) {
		super();
		this.quantite = quantite;
		this.statut = statut;
		this.dateDeLivraison = date;
		this.adresse = adresse;
		this.produit = produit;
	}

	
	
	@Override
	public String toString() {
		return "Ligne [getProduit()=" + getProduit() + ", getQuantite()=" + getQuantite() + ", getStatut()="
				+ getStatut() + ", getDate()=" + getDateDeLivraison() + ", getAdresse()=" + getAdresse() + ", getPrix()="
				+ getPrix() + "]";
	}

	public double getPrix()
	{
		if(!this.getStatut().equals("Sur Place"))
		{
			return this.getProduit().getPrix()*this.getQuantite()*1.1;
		}
		else
		{
			return this.getProduit().getPrix()*this.getQuantite();
		}
	}

	public double getFrais()
	{
		if(!this.getStatut().equals("Sur Place"))
		{
			return this.getProduit().getPrix()*this.getQuantite()*0.1;
		}
		else
		{
			return 0;
		}
	}
	
	public String getEtat()
	{
		LocalDateTime now = LocalDateTime.now();
		if(now.isBefore(this.getDateDeLivraison()))
		{
			return "En cours";
		}
		else
		{
			return "Livré";
		}
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
