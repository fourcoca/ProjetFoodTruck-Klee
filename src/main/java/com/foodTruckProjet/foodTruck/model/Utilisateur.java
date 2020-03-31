package com.foodTruckProjet.foodTruck.model;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Utilisateur  { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String prenom;
	private LocalDateTime dateDeNaissance;
	private String adresse;
	private String motDePasse;
	private String genre;
	private String societe;
	private String email;
	
	public Utilisateur()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDateTime getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDateTime dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Utilisateur(String nom, String prenom, LocalDateTime dateDeNaissance, String adresse,
			String motDePasse, String genre, String societe, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.motDePasse = motDePasse;
		this.genre = genre;
		this.societe = societe;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Utilisateur [getId()=" + getId() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getDateDeNaissance()=" + getDateDeNaissance() + ", getAdresse()=" + getAdresse()
				+ ", getMotDePasse()=" + getMotDePasse() + ", getGenre()=" + getGenre() + ", getSociete()="
				+ getSociete() + ", getEmail()=" + getEmail() + "]";
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return getMotDePasse();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return getEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
	
	
}

