package com.foodTruckProjet.foodTruck.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	private String disponibilite;
	private String famille;
	
	@ManyToMany(fetch = FetchType.EAGER)
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

	public boolean foudType(String typeRecher)
	{
		for (Type type2 : type) {
			if(type2.getNom().equals(typeRecher))
			{
				return true;
			}
		}
		return false;
	}

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
	
	public boolean isDispWeek(String SdateDeLivraisonSouhaite)
	{
		LocalDate dateDeLivraisonSouhaite = LocalDate.parse(SdateDeLivraisonSouhaite);
		String[] dispo = this.disponibilite.split(",");
		for (String jour : dispo) {
			if(jour.equals(Integer.toString(dateDeLivraisonSouhaite.getDayOfWeek().getValue())))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isDispHour(String dateDeCommandeS,String hour, String typeVoulu)
	{
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateDeCommande = LocalDateTime.parse(dateDeCommandeS+" "+hour, formatter);
		int heure = 0;
		for (Type type : this.type) {
			if(type.getNom().equals(typeVoulu))
			{
				heure=type.getHeure();
			}
		}
		System.out.println("Heure :");
		System.out.println(heure);	
		System.out.println("typeVoulu :");
		System.out.println(typeVoulu);
		LocalDateTime dateDeService = dateDeCommande.withHour(heure);
		System.out.println("dateDeService "+ dateDeService.toString());
		System.out.println("dateDeCommande "+ dateDeCommande.toString());
		return dateDeCommande.isBefore(dateDeService);
	}
}
