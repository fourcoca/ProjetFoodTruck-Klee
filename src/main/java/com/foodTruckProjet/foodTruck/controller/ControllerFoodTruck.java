package com.foodTruckProjet.foodTruck.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.foodTruckProjet.foodTruck.model.Catalogue;
import com.foodTruckProjet.foodTruck.model.Commande;
import com.foodTruckProjet.foodTruck.model.Contact;
import com.foodTruckProjet.foodTruck.model.Ligne;
import com.foodTruckProjet.foodTruck.model.Panier;
import com.foodTruckProjet.foodTruck.model.Produit;
import com.foodTruckProjet.foodTruck.model.Type;
import com.foodTruckProjet.foodTruck.model.Utilisateur;
import com.foodTruckProjet.foodTruck.repo.CommandeRepository;
import com.foodTruckProjet.foodTruck.repo.ContactRepositery;
import com.foodTruckProjet.foodTruck.repo.LigneRepository;
import com.foodTruckProjet.foodTruck.repo.ProduitRepository;
import com.foodTruckProjet.foodTruck.repo.TypeRepository;
import com.foodTruckProjet.foodTruck.repo.UtilisateurRepository;

@RestController
public class ControllerFoodTruck {

	@Autowired
	private ProduitRepository prepo;
	@Autowired
	private CommandeRepository crep;

	@Autowired
	private LigneRepository lrep;
	@Autowired
	private UtilisateurRepository userRepo;

	@Autowired
	private ContactRepositery cRepo;

	@Autowired
	private TypeRepository tRepo;

	@GetMapping("/accueil")
	public ModelAndView accueil(Model model) {
		ModelAndView modelAndView = new ModelAndView("accueil", "top3", prepo.findtop3());
		return modelAndView;
	}

	@GetMapping(path = "/", produces = "application/json")
	public List<Produit> getEmployees() {
		return prepo.findAll();
	}

	@GetMapping("/catalogue")
	public ModelAndView catalogue(Model model) {
		Catalogue catalogue = new Catalogue(prepo, tRepo);
		ModelAndView modelAndView = new ModelAndView("catalogue", "catalogue", catalogue);

		return modelAndView;
	}

	@GetMapping("/recherche")
	public ModelAndView rechercher(Model model, HttpServletRequest ht, @RequestParam("mot") String mot) {
		Catalogue catalogue = new Catalogue(prepo, tRepo);
		ModelAndView modelAndView = new ModelAndView("catalogue", "catalogue", catalogue);
		modelAndView.addObject("motRecherche", mot);
//		ht.getSession().setAttribute("type", type);
//		modelAndView.addObject("famille",famille);
		ht.getSession().setAttribute("date", null);
		ht.getSession().setAttribute("livraison", null);
		ht.getSession().setAttribute("heure", null);

		return modelAndView;
	}

	@GetMapping("/TypeMode")
	public ModelAndView Type(Model model, HttpServletRequest ht, @RequestParam("ModeType") int ModeType) {
		Catalogue catalogue = new Catalogue(prepo, tRepo);
		ModelAndView modelAndView = new ModelAndView("catalogue", "catalogue", catalogue);
		ht.getSession().setAttribute("mode", ModeType);
		ht.getSession().setAttribute("date", null);
		ht.getSession().setAttribute("livraison", null);
		ht.getSession().setAttribute("heure", null);
		return modelAndView;
	}

	@GetMapping("/ajouterQ-{ligne.produit.nom}")
	public ModelAndView ajouterUneQ(Model model, HttpServletRequest ht,
			@PathVariable(name = "ligne.produit.nom") String produit) {
		ModelAndView modelAndView = new ModelAndView("panier");
		Panier p = (Panier) ht.getSession().getAttribute("Panier");
		p.ajouterQuantite(produit, 1);
		ht.getSession().setAttribute("Panier", p);
		return modelAndView;
	}

	@GetMapping("/suppr-{ligne.produit.nom}")
	public ModelAndView supprimerP(Model model, HttpServletRequest ht,
			@PathVariable(name = "ligne.produit.nom") String produit) {
		ModelAndView modelAndView = new ModelAndView("panier");
		Panier p = (Panier) ht.getSession().getAttribute("Panier");
		p.supprimerLigne(produit);
		ht.getSession().setAttribute("Panier", p);
		return modelAndView;
	}

	@GetMapping("/diminuerQ-{ligne.produit.nom}")
	public ModelAndView diminuerUneQ(Model model, HttpServletRequest ht,
			@PathVariable(name = "ligne.produit.nom") String produit) {
		ModelAndView modelAndView = new ModelAndView("panier");
		Panier p = (Panier) ht.getSession().getAttribute("Panier");
		p.diminuerQuantite(produit, 1);
		ht.getSession().setAttribute("Panier", p);
		return modelAndView;
	}

	@GetMapping("/catalogue-{detailId}")
	public ModelAndView catalogueDetail(Model model, @PathVariable(name = "detailId") int detailId) {
		Catalogue catalogue = new Catalogue(prepo, tRepo);
		ModelAndView modelAndView = new ModelAndView("catalogue", "catalogue", catalogue);
		modelAndView.addObject("detail", prepo.findById(detailId).get());
		return modelAndView;
	}

	@PostMapping("/date-livraison")
	public ModelAndView AppliquerDate(Model model, HttpServletRequest ht, @RequestParam("date") String date,
			@RequestParam("livraison") String livraison, @RequestParam("heure") String heure,
			@RequestParam("Type") String type, @RequestParam("Famille") String famille) {
		Catalogue catalogue = new Catalogue(prepo, tRepo);
		ModelAndView modelAndView = new ModelAndView("catalogue", "catalogue", catalogue);
		ht.getSession().setAttribute("date", date);
		ht.getSession().setAttribute("livraison", livraison);
		ht.getSession().setAttribute("heure", heure);
		ht.getSession().setAttribute("famille", famille);
		ht.getSession().setAttribute("type", type);
		ht.getSession().setAttribute("mode", null);
		System.out.println(date);
		System.out.println(livraison);
		System.out.println(heure);
		System.out.println(famille);
		System.out.println(type);
		return modelAndView;
	}

	@PostMapping("/ajouter-panier-{detailId}")
	public ModelAndView AjouterAuPanier(Model model, HttpServletRequest ht,
			@PathVariable(name = "detailId") int detailId, @RequestParam("quantite") int quantite) {
		Produit detail = prepo.findById(detailId).get();
		Catalogue catalogue = new Catalogue(prepo, tRepo);
		ModelAndView modelAndView = new ModelAndView("catalogue", "catalogue", catalogue);
		Utilisateur current = (Utilisateur) ht.getSession().getAttribute("utilisateur");
		Panier p;
		if (ht.getSession().getAttribute("Panier") == null) {
			p = new Panier();
		} else {
			p = (Panier) ht.getSession().getAttribute("Panier");
		}

		String adresse = "";
		switch (ht.getSession().getAttribute("livraison").toString()) {
		case "Domicile":
			adresse = current.getAdresse();
			break;
		case "Societe":
			adresse = current.getSociete();
			break;
		case "Sur Place":
			adresse = "Sur place";
			break;
		default:
			break;
		}
		String str = ht.getSession().getAttribute("date") + " " + ht.getSession().getAttribute("heure");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		Ligne l = new Ligne(quantite, dateTime, adresse, detail);
		p.ajouterLigne(l);
		ht.getSession().setAttribute("Panier", p);

		return modelAndView;
	}

	@GetMapping("/connexion")
	public ModelAndView connectionGet(Model model, HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("connexion", "email", "");
		modelAndView.addObject("pwd", "");
		return modelAndView;
	}

	@PostMapping("/connexion")
	public ModelAndView connectionPost(@RequestParam(name = "email") String email,
			@RequestParam(name = "pwd") String mdp, Model model, HttpServletRequest ht) {
		ModelAndView reussite = new ModelAndView("redirect:/accueil");
		ModelAndView echec = new ModelAndView("/connexion");
		Utilisateur a = userRepo.findByEmailAndMotDePasse(email, mdp);
		if (a!=null && a.getEmail().equals(email)&&a.getMotDePasse().equals(mdp)) {
			ht.getSession().setAttribute("utilisateur", a);
			ht.getSession().setAttribute("erreur", 0);
			return reussite;
		} else {
			ht.getSession().setAttribute("erreur", 1);
			return echec;
		}
	}

	@GetMapping("/deconnexion")
	public ModelAndView getDeconnexion(Model model, HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("deconnexion");
		ht.getSession().setAttribute("utilisateur", null);

		ht.getSession().invalidate();
		return modelAndView;
	}

	@PostMapping("/deconnexion")
	public ModelAndView deconnexionValide(Model model, HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("deconnexion");
		ht.getSession().invalidate();
		ht.getSession().setAttribute("utilisateur", null);

		ht.getSession().invalidate();

		return modelAndView;
	}

	@GetMapping("/contacts")
	public ModelAndView contacts(Model model) {
		ModelAndView modelAndView = new ModelAndView("contacts");

		return modelAndView;
	}

	@PostMapping("/contacts")
	public ModelAndView contactes(Model model, @ModelAttribute(name = "personneModel") Contact pe,
			HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("contacts");

		// ht.getSession().setAttribute("personne", pe);
		// System.out.println(pe);
		cRepo.save(pe);

		return modelAndView;

	}

	@PostMapping("/inscription")
	public ModelAndView inscription(Model model, @RequestParam(name = "nom") String nom,
			@RequestParam(name = "prenom") String prenom, @RequestParam(name = "email") String email,
			@RequestParam(name = "adresse") String adresse, @RequestParam(name = "societe") String societe,
			@RequestParam(name = "motDePasse") String motDePasse, @RequestParam(name = "genre") String genre,
			@RequestParam(name = "dateDeNaissance") String dateDeNaissanceS, HttpServletRequest ht)
	{
		ModelAndView modelAndView = new ModelAndView("inscription");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateDeNaissance = LocalDateTime.parse(dateDeNaissanceS+" 00:00", formatter);
		Utilisateur user = new Utilisateur();
		user.setAdresse(adresse);
		user.setNom(nom);
		user.setEmail(email);
		user.setPrenom(prenom);
		user.setGenre(genre);
		user.setDateDeNaissance(dateDeNaissance);
		user.setMotDePasse(motDePasse);
		user.setEmail(email);
		user.setSociete(societe);
		
		
		
		userRepo.save(user);

		Utilisateur a = userRepo.findByEmailAndMotDePasse(email, motDePasse);
		if (a!=null && a.getEmail().equals(email)&&a.getMotDePasse().equals(motDePasse)) {
			modelAndView.addObject("Err", "Incription bien prise en compte");
			return modelAndView;
		} else {
			modelAndView.addObject("Err", "Incription échoué veuillez reassayer ou contact l'administrateur");
			return modelAndView;
		}

	}

	@GetMapping("/inscription")
	public ModelAndView inscrire(Model model) {
		ModelAndView modelAndView = new ModelAndView("inscription");
		return modelAndView;
	}

	@RequestMapping("/panier")
	public ModelAndView panier(Model model,
			HttpServletRequest ht) 
	{
		if(ht.getSession().getAttribute("utilisateur")==null)
		{ModelAndView modelAndView = new ModelAndView("accueil");
		return modelAndView;}
		
		ModelAndView modelAndView = new ModelAndView("panier");
		return modelAndView;
	}

	@RequestMapping("/valider")
	public ModelAndView valider(Model model, HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("valider");
		ModelAndView modelAndViewC = new ModelAndView("accueil");
		Panier p = (Panier) ht.getSession().getAttribute("Panier");
		if (p == null || ht.getSession().getAttribute("utilisateur") == null) {
			return modelAndViewC;
		}
		Utilisateur u = (Utilisateur) ht.getSession().getAttribute("utilisateur");

		for (Ligne ligne : p.getLignes()) {
			int Idproduit = ligne.getProduit().getId();
			Produit produit = prepo.findById(Idproduit).get();
			if (produit.getStock() - ligne.getQuantite() < 0) {
				produit.setStock(0);
			} else {
				produit.setStock(produit.getStock() - ligne.getQuantite());
			}
			prepo.save(produit);
			lrep.save(ligne);
		}
		Commande commande = new Commande(LocalDateTime.now(), u, p);
		if (p.getLignes().size() > 0) {
			crep.save(commande);
		}
		Utilisateur enbase = userRepo.findByEmail(u.getEmail());
		List<Commande> listCommande = enbase.getCommandes();
		listCommande.add(commande);
		userRepo.save(enbase);
		
		modelAndView.addObject("commande", commande);
		ht.getSession().setAttribute("Panier", new Panier());
		ht.getSession().setAttribute("date", null);
		ht.getSession().setAttribute("livraison", null);
		ht.getSession().setAttribute("heure", null);
		return modelAndView;
	}

	@RequestMapping("/profil")
	public ModelAndView profil(Model model) {
		ModelAndView modelAndView = new ModelAndView("profil/profile");
		return modelAndView;
	}

	@RequestMapping("/resume")
	public ModelAndView resume(Model model) {
		ModelAndView modelAndView = new ModelAndView("profil/resume");
		return modelAndView;
	}

	@RequestMapping("profil/historique-{UserID}")
	public ModelAndView profilHistorique(Model model,@PathVariable(name="UserID")int userID) {

		Utilisateur current = (Utilisateur) userRepo.findById(userID);
		ModelAndView modelAndView = new ModelAndView("profil/historique", "historique", crep.findByUtilisateur(current));

		return modelAndView;
	}

	@GetMapping("/modifier")
	public ModelAndView profilModifier(Model model) {
		ModelAndView modelAndView = new ModelAndView("profil/modifier");
		// Utilisateur user = new Utilisateur();
		// model.addAttribute("user",user);
		return modelAndView;
	}

	@PostMapping("/modifier")
	public ModelAndView profilModifier(Model model, @RequestParam(name = "nom") String nom,
			@RequestParam(name = "prenom") String prenom, @RequestParam(name = "email") String email,
			@RequestParam(name = "adresse") String adresse, @RequestParam(name = "societe") String societe,
			@RequestParam(name = "motDePasse") String motDePasse, @RequestParam(name = "genre") String genre,
			@RequestParam(name = "dateDeNaissance") String dateDeNaissanceS, HttpServletRequest ht) {
		Utilisateur user;
		ModelAndView modelAndView = new ModelAndView("profil/modifier");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateDeNaissance = LocalDateTime.parse(dateDeNaissanceS+" 00:00", formatter);
		user = (Utilisateur) ht.getSession().getAttribute("utilisateur");
		user.setAdresse(adresse);
		user.setNom(nom);
		user.setEmail(email);
		user.setPrenom(prenom);
		user.setGenre(genre);
		user.setDateDeNaissance(dateDeNaissance);
		user.setMotDePasse(motDePasse);
		user.setEmail(email);
		user.setSociete(societe);

		userRepo.saveAndFlush(user);

		return modelAndView;
	}

	@GetMapping("admin")
	public ModelAndView admin(Model model, HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("admin/authadmin", "email", "");
		modelAndView.addObject("pwd", "");
		return modelAndView;

	}

	@PostMapping("admin")
	public ModelAndView admine(@RequestParam(name = "email") String email, @RequestParam(name = "pwd") String mdp,
			Model model, HttpServletRequest ht)

	{
		ModelAndView echec = new ModelAndView("admin/authadmin");
		ModelAndView reussite = new ModelAndView("admin/homeAdmin");

		Utilisateur a = userRepo.findByEmailAndMotDePasse(email, mdp);

		if(a==null)
		{
			ht.getSession().setAttribute("erreur", 1);
			return echec;
		}
		if (a.getEmail().equals("minato@yahoo.fr") && a.getMotDePasse().equals("admin")) {
			ht.getSession().setAttribute("user", a);
			ht.getSession().setAttribute("erreur", 0);
			return reussite;
		} else {
			ht.getSession().setAttribute("erreur", 1);
			return echec;
		}

	}

	@GetMapping("/decon")
	public ModelAndView getDeconnexionAdmin(Model model, HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("deconnexion");
		ht.getSession().setAttribute("user", null);

		ht.getSession().invalidate();
		return modelAndView;
	}

	@PostMapping("/decon")
	public ModelAndView deconnexion(Model model, HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("deconnexion");
		ht.getSession().invalidate();
		ht.getSession().setAttribute("user", null);

		ht.getSession().invalidate();

		return modelAndView;
	}

	@RequestMapping("admin/listUtilisateur")
	public ModelAndView adminAfficherUtilisateur(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/listUtilisateur");
		model.addAttribute("artList", userRepo.findAll());
		return modelAndView;
	}

	@RequestMapping("/print")
	public ModelAndView adminPrintUser(Model model, @RequestParam(name = "id") int id, HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("admin/selectUtilisateur");
		// il peut en avoir deux email
		// model.addAttribute("artList", userRepo.findByEmail(email));
		model.addAttribute("List", userRepo.findById(id));

		// Utilisateur oneUser=userRepo.findById(id);

		// ht.getSession().setAttribute("userId", oneUser);
		// model.getAttribute("artList");
		return modelAndView;

	}

	@RequestMapping("/supp")
	public ModelAndView adminSuprUser(Model model, @RequestParam(name = "id") int id) {
		ModelAndView modelAndView = new ModelAndView("admin/supprimerUtilisateur");
		userRepo.deleteById(id);
		model.addAttribute("artList", userRepo.findAll());

		return modelAndView;

	}

	@RequestMapping("/modif")
	public ModelAndView admineModifierUtilisateur(Model model, @RequestParam(name = "id") int id,
			HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("admin/modifierUtilisateur");
		// Utilisateur user = new Utilisateur();
		// model.addAttribute("user",user);
		Utilisateur oneUser = userRepo.findById(id);

		ht.getSession().setAttribute("user", oneUser);
		return modelAndView;
	}
	
	
	








	@PostMapping("/modif")
	public ModelAndView adminModifierUtilisateur(Model model, @RequestParam(name = "nom") String nom,
			@RequestParam(name = "prenom") String prenom, @RequestParam(name = "email") String email,
			@RequestParam(name = "adresse") String adresse, @RequestParam(name = "societe") String societe,
			@RequestParam(name = "motDePasse") String motDePasse, @RequestParam(name = "genre") String genre,
			@RequestParam(name = "dateDeNaissance") String dateDeNaissanceS, HttpServletRequest ht) {
		
		ModelAndView modelAndView2 = new ModelAndView("admin/listUtilisateur");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateDeNaissance = LocalDateTime.parse(dateDeNaissanceS+" 00:00", formatter);
		Utilisateur user;

		user = (Utilisateur) ht.getSession().getAttribute("user");
		user.setAdresse(adresse);
		user.setNom(nom);
		user.setEmail(email);
		user.setPrenom(prenom);
		user.setGenre(genre);
		user.setDateDeNaissance(dateDeNaissance);
		user.setMotDePasse(motDePasse);
		user.setEmail(email);
		user.setSociete(societe);
		

		userRepo.saveAndFlush(user);

		model.addAttribute("artList", userRepo.findAll());
		return modelAndView2;

	}

	@RequestMapping("admin/ajouterUtilisateur")
	public ModelAndView adminAjouterUtilisateur(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/ajouterUtilisateur");
		return modelAndView;
	}

	@PostMapping("admin/ajouterUtilisateur")
	public ModelAndView adminAjouterUtilisateurs(Model model, @RequestParam(name = "nom") String nom,
			@RequestParam(name = "prenom") String prenom, @RequestParam(name = "email") String email,
			@RequestParam(name = "adresse") String adresse, @RequestParam(name = "societe") String societe,
			@RequestParam(name = "motDePasse") String motDePasse, @RequestParam(name = "genre") String genre,
			@RequestParam(name = "dateDeNaissance") String dateDeNaissanceS)
	{
		ModelAndView modelAndView = new ModelAndView("admin/listUtilisateur");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateDeNaissance = LocalDateTime.parse(dateDeNaissanceS+" 00:00", formatter);
		Utilisateur user = new Utilisateur();
		user.setAdresse(adresse);
		user.setNom(nom);
		user.setEmail(email);
		user.setPrenom(prenom);
		user.setGenre(genre);
		user.setDateDeNaissance(dateDeNaissance);
		user.setMotDePasse(motDePasse);
		user.setEmail(email);
		user.setSociete(societe);
		
		
		
		userRepo.save(user);


		model.addAttribute("artList", userRepo.findAll());

		return modelAndView;
	}

	@RequestMapping("/supr")
	public ModelAndView adminSuprMessage(Model model, @RequestParam(name = "id") int id) {
		ModelAndView modelAndView = new ModelAndView("admin/listMessagerie");
		cRepo.deleteById(id);
		model.addAttribute("List", cRepo.findAll());

		return modelAndView;

	}

	@RequestMapping("admin/listMessagerie")
	public ModelAndView adminAfficherMeassagerie(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/listMessagerie");
		model.addAttribute("List", cRepo.findAll());
		return modelAndView;
	}

	@RequestMapping("admin/listCatalogue")
	public ModelAndView adminAfficherCatalogue(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/listCatalogue");
		model.addAttribute("prodList", prepo.findAll());
		return modelAndView;
	}

	@RequestMapping("/suppr")
	public ModelAndView adminSuprCatalogue(Model model, @RequestParam(name = "id") int id) {
		ModelAndView modelAndView = new ModelAndView("admin/listCatalogue");
		prepo.deleteById(id);

		model.addAttribute("prodList", prepo.findAll());

		return modelAndView;

	}
	
	@RequestMapping("admin/modifierCatalogue")
	public ModelAndView adminModifierCatalogue(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/modifierCatalogue");
		return modelAndView;
	}

	@GetMapping("admin/ajouterCatalogue")
	public ModelAndView adminAjouterCatalogue(Model model, HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("admin/ajouterCatalogue");
		List<String> user = new ArrayList<String>();
		// Famille : Boissoin froide, boisson chaude, entree, plat, dessert
		user.add("Boissoin froide");
		user.add("boisson chaude");
		user.add(" entree");
		user.add(" plat");
		user.add(" dessert");

		// ht.setAttribute(name, o);
		model.addAttribute("famille", user);
		ht.getSession().setAttribute("famille", user);
		return modelAndView;

	}

	@PostMapping("admin/ajouterCatalogue")
	public ModelAndView adminAjouterCatalogueS(Model model, @ModelAttribute(name = "catalogues") Produit pe,

			@ModelAttribute(name = "famille") String famille, @ModelAttribute(name = "ptdej") String ptdej,
			@ModelAttribute(name = "dej") String dej, @ModelAttribute(name = "r") String r,
			@ModelAttribute(name = "g") String g, @ModelAttribute(name = "lundi") String lundi,
			@ModelAttribute(name = "mardi") String mardi, @ModelAttribute(name = "mercredi") String mercredi,
			@ModelAttribute(name = "jeudi") String jeudi, @ModelAttribute(name = "vendredi") String vendredi,
			@ModelAttribute(name = "samedi") String samedi, @ModelAttribute(name = "dimanche") String dimanche,
			HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("admin/ajouterCatalogue");

		String test = "";

		String res = "";
		if (famille.equals("plat"))

		{
			test = "plat";
		}
		if (!lundi.equals(""))

		{
			res += lundi + ",";
		}
		if (!mardi.equals(""))

		{
			res += mardi + ",";
		}

		if (!mercredi.equals(""))

		{
			res += mercredi + ",";
		}

		if (!jeudi.equals(""))

		{
			res += jeudi + ",";
		}

		if (!vendredi.equals(""))

		{
			res += vendredi + ",";
		}
		if (!samedi.equals(""))

		{
			res += samedi + ",";
		}

		if (!dimanche.equals(""))

		{
			res += dimanche + ",";

		}

		System.out.println(res);
		pe.setDisponibilite(res);
		if (!ptdej.equals(""))

		{
			ptdej.toString();
			pe.setDisponibilite(res);
			Type tppe = (Type) tRepo.findByNom(ptdej);
			pe.getType().add(tppe);
		}
		if (!dej.equals("")) {
			Type tppe = (Type) tRepo.findByNom(dej);
			pe.getType().add(tppe);
		}
		if (!r.equals("")) {
			Type tppe = (Type) tRepo.findByNom(r);
			pe.getType().add(tppe);
		}
		if (!g.equals("")) {
			Type tppe = (Type) tRepo.findByNom(g);
			pe.getType().add(tppe);
		}

		prepo.save(pe);
		System.out.println(pe);
		return modelAndView;

	}

	@GetMapping("/type")
	public ModelAndView adminAjouterType(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/type");
		return modelAndView;
	}

	@PostMapping("/type")
	public ModelAndView adminAjouterTypes(Model model, @ModelAttribute(name = "types") Type t, HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("admin/type");

		// pe.getType().add(t);
//		t.setNom(t.getNom());
//		t.setHeure(t.getHeure());
//		pe.getType().add(t);

		ht.getSession().setAttribute("tpes", t);
		tRepo.save(t);
		System.out.println(t);
//		
		System.out.println("hello");
		return modelAndView;

	}

	@GetMapping("admin/modifierHoraire")
	public ModelAndView adminModifierHoraire(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/modifierHoraire");
		modelAndView.addObject("heurePD", tRepo.findByNom("Petit_Dejeuner").getHeure());
		modelAndView.addObject("heureD", tRepo.findByNom("Dejeuner").getHeure());
		modelAndView.addObject("heureG", tRepo.findByNom("Gouter").getHeure());
		modelAndView.addObject("heureDiner", tRepo.findByNom("Diner").getHeure());
		return modelAndView;
	}

	@PostMapping("admin/modifierHoraire")
	public ModelAndView adminModifierHorairePost(Model model, @RequestParam("heurePD") String heurePD,
			@RequestParam("heureD") String heureD, @RequestParam("heureG") String heureG,
			@RequestParam("heureDiner") String heureDiner) {
		ModelAndView modelAndView = new ModelAndView("admin/modifierHoraire");
		Type PD = tRepo.findByNom("Petit_Dejeuner");
		Type D = tRepo.findByNom("Dejeuner");
		Type G = tRepo.findByNom("Gouter");
		Type Din = tRepo.findByNom("Diner");
		
		PD.setHeure(Integer.parseInt(heurePD));
		D.setHeure(Integer.parseInt(heureD));
		G.setHeure(Integer.parseInt(heureG));
		Din.setHeure(Integer.parseInt(heureDiner));

		tRepo.save(PD);
		tRepo.save(D);
		tRepo.save(G);
		tRepo.save(Din);
		
		modelAndView.addObject("heurePD", PD.getHeure());
		modelAndView.addObject("heureD", D.getHeure());
		modelAndView.addObject("heureG", G.getHeure());
		modelAndView.addObject("heureDiner", Din.getHeure());
		return modelAndView;
	}

//	@RequestMapping("/supr")
//	public ModelAndView adminSuprHoraire(Model model ,@RequestParam(name="id") int id)
//	{
//		ModelAndView modelAndView = new ModelAndView("admin/listMessagerie");
//		tRepo.deleteById(id);
//		model.addAttribute("List", cRepo.findAll());
//		
//		return modelAndView;
//		
//	}

	
	@RequestMapping("/modife")
	public ModelAndView admineModifierCatalogue(Model model,@RequestParam(name="id") int id,HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("admin/modifierCatalogue");
		
		Produit produitAmodifier=prepo.findById(id).get();
		ht.getSession().setAttribute("produitAmodifier", produitAmodifier);
		return modelAndView;
	}
	
	@PostMapping("/modife")
	public ModelAndView adminModifierCatalogue(Model model,@ModelAttribute(name="catalogues") Produit pe,
			@ModelAttribute(name="famille")String famille,
			@RequestParam(name="prix")double prix,
			@RequestParam(name="stock")int stock,
			@ModelAttribute(name="ptdej")String ptdej,@ModelAttribute(name="dej")String dej,
			@ModelAttribute(name="r")String r,@ModelAttribute(name="g")String g,
			@ModelAttribute(name="lundi")String lundi,@ModelAttribute(name="mardi")String mardi,
			@ModelAttribute(name="mercredi")String mercredi,@ModelAttribute(name="jeudi")String jeudi,
			@ModelAttribute(name="vendredi")String vendredi,@ModelAttribute(name="samedi")String samedi,
			@ModelAttribute(name="dimanche")String dimanche,
			HttpServletRequest ht)
	{
		
		ModelAndView modelAndView2 = new ModelAndView("admin/listCatalogue");
		Produit produitAmodifier;
		produitAmodifier=(Produit) ht.getSession().getAttribute("produitAmodifier");
		ht.getSession().setAttribute("produitAmodifier", produitAmodifier);
		
		
		List<Type> types = new ArrayList<Type>();
		
		
		String res = "";
		
		
		if(!lundi.equals(""))
		{
			res+=lundi+",";
		}
		if(!mardi.equals(""))
				{
					res+=mardi+",";
				}
		if(!mercredi.equals(""))
		{
			res+=mercredi+",";
		}
		if(!jeudi.equals(""))
		{
			res+=jeudi+",";
		}
		if(!vendredi.equals(""))
		{
			res+=vendredi+",";
		}
		if(!samedi.equals(""))
		{
			res+=samedi+",";
		}
		if(!dimanche.equals(""))
		{
			res+=dimanche;
		}
		
		
		if(pe.getImage()!=null)
		{
			produitAmodifier.setImage(pe.getImage());
		}
			else
		{
				produitAmodifier.setImage(produitAmodifier.getImage());
		}
		
		
		
		if(pe.getNom()!=null)
		{
			produitAmodifier.setNom(pe.getNom());
		}
			else
		{
				produitAmodifier.setNom(produitAmodifier.getNom());
		}
		
		double t=produitAmodifier.getPrix();
		if(pe.getPrix()>0)
		{
			produitAmodifier.setPrix(prix);
		}
			else
		{
				produitAmodifier.setPrix(t);
		}
		if(pe.getStock()>0)
		{
			produitAmodifier.setStock(pe.getStock());
		}
			else
		{
				produitAmodifier.setStock(produitAmodifier.getStock());
		}
		if(pe.getDescription()!=null)
		{
			produitAmodifier.setDescription(pe.getDescription());
		}
			else
		{
				produitAmodifier.setDescription(produitAmodifier.getDescription());
		}
		if(pe.getFamille()!=null)
		{
			produitAmodifier.setFamille(pe.getFamille());
		}
			else
		{
				produitAmodifier.setFamille(produitAmodifier.getFamille());
		}
		
		if(!ptdej.equals(""))
		{
			
			Type tppe=(Type) tRepo.findByNom(ptdej);
			types.add(tppe);

		}
		if(!dej.equals(""))
		{
			//Type tppe =new Type(dej.toString(),10);
			//String teste=(String) ht.getSession().getAttribute("famille");
			//tRepo.save(tppe);
			Type tppe=(Type) tRepo.findByNom(dej);
			types.add(tppe);
//			prepo.save(pe);
//			System.out.println(dej);
//			System.out.println(dej.toString());
//			System.out.println( tppe);
//			System.out.println(res);
//			System.out.println(test);
//			System.out.println( pe);
		//user.add(new Type(ptdej,8));
		}
		if(!r.equals(""))
		{
			//Type tppe =new Type(r.toString(),10);
			//String teste=(String) ht.getSession().getAttribute("famille");
			//tRepo.save(tppe);
			Type tppe=(Type) tRepo.findByNom(r);
			types.add(tppe);
			//prepo.save(pe);
//			System.out.println(r);
//			System.out.println(r.toString());
//			System.out.println(res);
//			System.out.println(test);
//			System.out.println( tppe);
//			System.out.println( pe);
		//user.add(new Type(ptdej,8));
		}
		if(!g.equals(""))
		{
			Type tppe=(Type) tRepo.findByNom(g);
			types.add(tppe);
		}
		System.out.println(produitAmodifier);
		produitAmodifier.setDisponibilite(res);
		produitAmodifier.setType(types);
			prepo.saveAndFlush(produitAmodifier);
			
			
			
			
			
			model.addAttribute("prodList", prepo.findAll());
			return modelAndView2;
	}
}
