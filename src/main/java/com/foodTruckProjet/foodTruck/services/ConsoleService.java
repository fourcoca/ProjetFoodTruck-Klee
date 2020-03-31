package com.foodTruckProjet.foodTruck.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.foodTruckProjet.foodTruck.model.Commande;
import com.foodTruckProjet.foodTruck.model.Famille;
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
public class ConsoleService implements CommandLineRunner {

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

		// initi();
		//baseDeDonneeR();
	}

	private void baseDeDonneeR() {
		Utilisateur u = new Utilisateur("Kantouar", "Ali", LocalDateTime.now(), "Paris", "10", "Homme", "Paris",
				"10@10");
		urep.save(u);

		urrep.save(new UserRole(u, Role.ADMIN));

		Type t1 = new Type("Petit_Dejeuner", 11);
		trep.save(t1);
		Type t2 = new Type("Dejeuner", 15);
		trep.save(t2);
		Type t3 = new Type("Gouter", 16);
		trep.save(t3);
		Type t4 = new Type("Diner", 20);
		trep.save(t4);

		Produit cafe = new Produit("http://127.0.0.1:8887/boissonchaude/cafe.jpg", "Cafe", 3.0, 100, "Pur café",
				"1,2,3,4,5,6,7", Famille.BC.toString(), new ArrayList<Type>());
		ArrayList<Type> art = (ArrayList<Type>) cafe.getType();
		art.add(t1);
		art.add(t2);
		art.add(t3);
		art.add(t4);
		cafe.setType(art);
		prep.save(cafe);

		Produit cchaud = new Produit("http://127.0.0.1:8887/boissonchaude/chocolatchaud.jpg", "Chocolat Chaud", 3.0,
				100, "Chocolat et lait", "1,2,3,4,5,6,7", Famille.BC.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) cchaud.getType();
		art.add(t1);
		art.add(t2);
		art.add(t3);
		art.add(t4);
		cchaud.setType(art);
		prep.save(cchaud);

		Produit theg = new Produit("http://127.0.0.1:8887/boissonchaude/cafe.jpg", "The glacee", 2.0, 100,
				"The et peche", "1,2,3,4,5,6,7", Famille.BF.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) theg.getType();
		art.add(t1);
		art.add(t2);
		art.add(t3);
		art.add(t4);
		theg.setType(art);
		prep.save(theg);

		Produit eaug = new Produit("http://127.0.0.1:8887/boissonfroide/eaugaz.jpg", "Eau gazeuse", 2.0, 100,
				"Chocolat et lait", "1,2,3,4,5,6,7", Famille.BF.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) eaug.getType();
		art.add(t1);
		art.add(t2);
		art.add(t3);
		art.add(t4);
		eaug.setType(art);
		prep.save(eaug);

		Produit avocat = new Produit("http://127.0.0.1:8887/Entr%C3%A9e/AvocatCrevette.jpg", "Avocat crevette", 5.0,
				100, "Avocat, crevette et mayonaise maison", "1,2,3,4,5,6,7", Famille.Entree.toString(),
				new ArrayList<Type>());
		art = (ArrayList<Type>) avocat.getType();
		art.add(t2);
		art.add(t4);
		avocat.setType(art);
		prep.save(avocat);

		Produit fri = new Produit("http://127.0.0.1:8887/Entr%C3%A9e/Frittes.jpg", "Frites", 5.0, 100,
				"Frites, sel de l'Himalaya et poivre", "1,2,3,4,5,6,7", Famille.Entree.toString(),
				new ArrayList<Type>());
		art = (ArrayList<Type>) fri.getType();
		art.add(t2);
		art.add(t4);
		fri.setType(art);
		prep.save(fri);

		Produit mini = new Produit("http://127.0.0.1:8887/Entr%C3%A9e/MiniWrap.jpg", "Mini Wrap", 5.0, 100,
				"Fajitas, poulet, legumes de saisons et sauce cocktail", "1,2,3,4,5,6,7", Famille.Entree.toString(),
				new ArrayList<Type>());
		art = (ArrayList<Type>) mini.getType();
		art.add(t2);
		art.add(t4);
		mini.setType(art);
		prep.save(mini);

		Produit moza = new Produit("http://127.0.0.1:8887/Entr%C3%A9e/MozzaStick.jpg", "Moza stick", 5.0, 100,
				"Moza, chapellure et sauce au choix", "1,2,3,4,5,6,7", Famille.Entree.toString(),
				new ArrayList<Type>());
		art = (ArrayList<Type>) moza.getType();
		art.add(t2);
		art.add(t4);
		moza.setType(art);
		prep.save(moza);

		Produit onio = new Produit("http://127.0.0.1:8887/Entr%C3%A9e/OnionRing.jpg", "Onion ring", 5.0, 100,
				"Onion, chapelure, frie dans de l'huile d'olive bio extra vierge avec sauce au choix ", "1,2,3,4,5,6,7",
				Famille.Entree.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) onio.getType();
		art.add(t2);
		art.add(t4);
		onio.setType(art);
		prep.save(onio);

		Produit painAil = new Produit("http://127.0.0.1:8887/Entr%C3%A9e/PainaLail.jpg", "Pain à l'ail", 5.0, 100,
				"Pain maison , ail frais et fines herbes", "1,2,3,4,5,6,7",
				Famille.Entree.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) painAil.getType();
		art.add(t2);
		art.add(t4);
		painAil.setType(art);
		prep.save(painAil);
	
		Produit abr = new Produit("http://127.0.0.1:8887/Entr%C3%A9e/ThonAbricot.jpg", "Abricot au thon", 5.0, 100,
				"Abricot frais, thon et mayonaise maison", "1,2,3,4,5,6,7",
				Famille.Entree.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) abr.getType();
		art.add(t2);
		art.add(t4);
		abr.setType(art);
		prep.save(abr);

		
		Produit gla = new Produit("http://127.0.0.1:8887/Dessert/Glace.jpg", "Glace", 8.0, 100,
				"Parfum au choix parmis une selection de plus de 175 parfums allant de cookies à brownie bio", "1,2,3,4,5,6,7",
				Famille.Dessert.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) gla.getType();
		art.add(t2);
		art.add(t3);
		art.add(t4);
		gla.setType(art);
		prep.save(gla);

		Produit tira = new Produit("http://127.0.0.1:8887/Dessert/Tiramisu.jpg", "Tiramisu", 8.0, 100,
				"Tiramisu fait maison par un chef italien d'après la recette originale", "1,2,3,4,5,6,7",
				Famille.Dessert.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) tira.getType();
		art.add(t2);
		art.add(t3);
		art.add(t4);
		tira.setType(art);
		prep.save(tira);

		Produit tarte = new Produit("http://127.0.0.1:8887/Dessert/Tarte.jpg", "Tarte aux pommes du jardin", 8.0, 100,
				"Tarte fais à partir de pommes du jardin cultiver avec amour et bienveillance", "1,2,3,4,5,6,7",
				Famille.Dessert.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) tarte.getType();
		art.add(t2);
		art.add(t3);
		art.add(t4);
		tarte.setType(art);
		prep.save(tarte);

		Produit ham = new Produit("http://127.0.0.1:8887/Plat/Hamburger.jpg", "Hamburger", 15.0, 100,
				"Hamburger avec sa garniture de légumes bio et sa viande française", "1,2,3,4,5,6,7",
				Famille.Plat.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) ham.getType();
		art.add(t2);
		art.add(t4);
		ham.setType(art);
		prep.save(ham);	

		Produit ppes = new Produit("http://127.0.0.1:8887/Plat/Pattes.jpg", "Pates au pesto", 15.0, 100,
				"Pates au pesto accompagné de basilic et de parmesan", "1,2,3,4,5,6,7",
				Famille.Plat.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) ppes.getType();
		art.add(t2);
		art.add(t4);
		ppes.setType(art);
		prep.save(ppes);	

		Produit pizza = new Produit("http://127.0.0.1:8887/Plat/Pizza.jpg", "Pizza", 15.0, 100,
				"Pizza avec tomates cerises, frommage de chevre le tout est bio évidemment", "1,2,3,4,5,6,7",
				Famille.Plat.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) pizza.getType();
		art.add(t2);
		art.add(t4);
		pizza.setType(art);
		prep.save(pizza);	

		Produit salade = new Produit("http://127.0.0.1:8887/Plat/Salade.jpg", "Salade composée", 15.0, 100,
				"Salades, concombres, tomates et petits croutons à l'ail", "1,2,3,4,5,6,7",
				Famille.Plat.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) salade.getType();
		art.add(t2);
		art.add(t4);
		salade.setType(art);
		prep.save(salade);	

		Produit soupe = new Produit("http://127.0.0.1:8887/Plat/Soupe.jpg", "Velouté de légumes", 15.0, 100,
				"Soupe de légumes bio avec ciboulette", "1,2,3,4,5,6,7",
				Famille.Plat.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) soupe.getType();
		art.add(t2);
		art.add(t4);
		soupe.setType(art);
		prep.save(soupe);	
		
		Produit steak = new Produit("http://127.0.0.1:8887/Plat/Steak.jpg", "Steak pur boeuf", 15.0, 100,
				"Soupe de légumes bio avec ciboulette", "1,2,3,4,5,6,7",
				Famille.Plat.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) steak.getType();
		art.add(t2);
		art.add(t4);
		steak.setType(art);
		prep.save(steak);	
		
		Produit sushi = new Produit("http://127.0.0.1:8887/Plat/Sushi.jpg", "Sushi", 15.0, 100,
				"Sushi (thon,saumon) frais", "1,2,3,4,5,6,7",
				Famille.Plat.toString(), new ArrayList<Type>());
		art = (ArrayList<Type>) sushi.getType();
		art.add(t2);
		art.add(t4);
		sushi.setType(art);
		prep.save(sushi);			
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private void initi() {
		Utilisateur u = new Utilisateur("Kantouar", "Ali", LocalDateTime.now(), "Paris", "10", "Homme", "Paris",
				"10@10");
		urep.save(u);

		urrep.save(new UserRole(u, Role.ADMIN));

		Produit p = new Produit("image", "produit1", 10.0, 100, "bien", "1", "boisson froide", new ArrayList<Type>());
		Type t = new Type("Petit_Dejeuner", 8);
		trep.save(t);
		ArrayList<Type> art = (ArrayList<Type>) p.getType();
		art.add(t);
		p.setType(art);
		prep.save(p);

		Produit p2 = new Produit("image2", "produit2", 12.0, 102, "bien2", "1,2", "boisson chaude",
				new ArrayList<Type>());
		Type t2 = new Type("Dejeuner", 14);
		trep.save(t2);
		ArrayList<Type> art2 = (ArrayList<Type>) p2.getType();
		art2.add(t2);
		p2.setType(art2);
		prep.save(p2);

		Ligne un = new Ligne(1, LocalDateTime.now(), u.getAdresse(), p);
		Ligne deux = new Ligne(2, LocalDateTime.now(), u.getSociete(), p2);

		Produit p3 = new Produit("image3", "produit3", 1.0, 100, "bienbien", "1,2,3", "plat", new ArrayList<Type>());
		ArrayList<Type> art3 = (ArrayList<Type>) p3.getType();
		art3.add(t);
		art3.add(t2);
		p3.setType(art3);
		prep.save(p3);

		Produit p4 = new Produit("image4", "produit4", 1.0, 100, "bienbien", "1,3", "plat", new ArrayList<Type>());
		ArrayList<Type> art4 = (ArrayList<Type>) p4.getType();
		art4.add(t);
		art4.add(t2);
		p4.setType(art4);
		prep.save(p4);

		Produit p5 = new Produit("image5", "produit5", 2.0, 100, "bienbien", "1,2", "plat", new ArrayList<Type>());
		ArrayList<Type> art5 = (ArrayList<Type>) p5.getType();
		art5.add(t);
		p5.setType(art5);
		prep.save(p5);

		Produit p6 = new Produit("image6", "produit6", 3.0, 100, "bienbien", "1,2,3", "plat", new ArrayList<Type>());
		ArrayList<Type> art6 = (ArrayList<Type>) p6.getType();
		art6.add(t2);
		p6.setType(art6);
		prep.save(p6);

		lrep.save(un);
		lrep.save(deux);

		Panier panier = new Panier();
		panier.ajouterLigne(un);
		panier.ajouterLigne(deux);

		Commande commande = new Commande(LocalDateTime.now(), u, panier);
		crep.save(commande);
	}

}
