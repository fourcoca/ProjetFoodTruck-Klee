package com.foodTruckProjet.foodTruck.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String image;
	private String nom;
	private double prix;
	private int stock;
	private String description;
	//lundi 1,23,4
	private String disponibilite;
	private String famille;
	
	@Column(name = "type", nullable = true)
	@ManyToMany
	private List<Type> type = new ArrayList<Type>();
	
	public Produit()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}

	public String getFamille() {
		return famille;
	}

	public void setFamille(String famille) {
		this.famille = famille;
	}

	
	@Column(name = "type", nullable = true)
	public List<Type> getType() {
		return type;
	}

	public void setType(List<Type> type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Produit [getId()=" + getId() + ", getImage()=" + getImage() + ", getNom()=" + getNom() + ", getPrix()="
				+ getPrix() + ", getStock()=" + getStock() + ", getDescription()=" + getDescription()
				+ ", getDisponibilite()=" + getDisponibilite() + ", getFamille()=" + getFamille() + ", getType()="
				+ getType() + "]";
	}

	public Produit(String image, String nom, double prix, int stock, String description, String disponibilite,
			String famille, ArrayList<Type> type) {
		super();
		this.image = image;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
		this.description = description;
		this.disponibilite = disponibilite;
		this.famille = famille;
		this.type = type;
	}
	
	public boolean isDispWeek(LocalDate dateDeLivraisonSouhaite)
	{
		String[] dispo = this.disponibilite.split(",");
		for (String jour : dispo) {
			if(jour.equals(Integer.toString(dateDeLivraisonSouhaite.getDayOfWeek().getValue())))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isDispHour(LocalDateTime dateDeCommande, String typeVoulu)
	{
		int heure = 0;
		for (Type type : this.type) {
			if(type.getNom().equals(typeVoulu))
			{
				heure=type.getHeure();
			}
		}
		
		dateDeCommande = dateDeCommande.withHour(heure);
		LocalDateTime now = LocalDateTime.now();
		return now.isBefore(dateDeCommande);
	}
}
