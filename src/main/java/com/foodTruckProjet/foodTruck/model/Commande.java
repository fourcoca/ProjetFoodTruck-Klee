package com.foodTruckProjet.foodTruck.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private LocalDateTime dateDeCommande;

	@ManyToOne
	private Utilisateur utilisateur;

	@ManyToMany
	private List<Ligne> lignes;

	public Commande() {

	}

	public Commande(LocalDateTime dateDeCommande, Utilisateur utilisateur, Panier panier) {
		super();
		this.dateDeCommande = dateDeCommande;
		this.utilisateur = utilisateur;
		this.lignes = panier.getLignes();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateDeCommande() {
		return dateDeCommande;
	}

	public void setDateDeCommande(LocalDateTime dateDeCommande) {
		this.dateDeCommande = dateDeCommande;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Ligne> getLignes() {
		return lignes;
	}

	public void setLignes(List<Ligne> lignes) {
		this.lignes = lignes;
	}
}
