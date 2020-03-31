package com.foodTruckProjet.foodTruck.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.foodTruckProjet.foodTruck.model.Commande;
import com.foodTruckProjet.foodTruck.model.Ligne;
import com.foodTruckProjet.foodTruck.model.Panier;
import com.foodTruckProjet.foodTruck.model.Produit;
import com.foodTruckProjet.foodTruck.model.Role;
import com.foodTruckProjet.foodTruck.model.Type;
import com.foodTruckProjet.foodTruck.model.UserRole;
import com.foodTruckProjet.foodTruck.model.Utilisateur;
import com.foodTruckProjet.foodTruck.repo.CommandeRepository;
import com.foodTruckProjet.foodTruck.repo.LigneRepository;
import com.foodTruckProjet.foodTruck.repo.ProduitRepository;
import com.foodTruckProjet.foodTruck.repo.TypeRepository;
import com.foodTruckProjet.foodTruck.repo.UserRoleRepository;
import com.foodTruckProjet.foodTruck.repo.UtilisateurRepository;

@Service
public class ConsoleService implements CommandLineRunner{


	@Autowired
	UtilisateurRepository urep;
	
	@Autowired
	TypeRepository trep;
	
	@Autowired
	ProduitRepository prep;
	
	@Autowired
	LigneRepository lrep;
	
	@Autowired
	CommandeRepository crep;

	@Autowired
	UserRoleRepository urrep;
	
	@Override
	public void run(String... args) throws Exception {
		//initi();
	}

	private void initi() {
		Utilisateur u = new Utilisateur("Kantouar", "Ali", LocalDateTime.now(), "Paris",
				"10", "Gomme", "Paris", "10@10");
		urep.save(u);

		urrep.save(new UserRole(u, Role.ADMIN));
		Produit p = new Produit("image", "produit1", 10.0, 100, "bien", "1",
				"boisson froide", new ArrayList<Type>());
		Type t = new Type("Petit déjeuner",8);
		trep.save(t);
		ArrayList<Type> art = (ArrayList<Type>) p.getType();
		art.add(t);
		p.setType(art);
		prep.save(p);
		
		Produit p2 = new Produit("image2", "produit2", 12.0, 102, "bien2", "1,2",
				"boisson chaude", new ArrayList<Type>());
		Type t2 = new Type("Déjeuner",14);
		trep.save(t2);
		ArrayList<Type> art2 = (ArrayList<Type>) p2.getType();
		art2.add(t2);
		p2.setType(art2);
		prep.save(p2);
		
		Ligne un = new Ligne(1, "en cours", LocalDateTime.now(), u.getAdresse(), p);
		Ligne deux = new Ligne(2, "en cours", LocalDateTime.now(), u.getSociete(), p2);
		
		lrep.save(un);
		lrep.save(deux);
		
		Panier panier = new Panier();
		panier.ajouterLigne(un);
		panier.ajouterLigne(deux);
		
		Commande commande = new Commande(LocalDateTime.now(),u,panier);
		crep.save(commande);
	}
	
}
