package com.foodTruckProjet.foodTruck.controller;

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

import com.foodTruckProjet.foodTruck.model.Contact;
import com.foodTruckProjet.foodTruck.model.Produit;
import com.foodTruckProjet.foodTruck.model.Type;
import com.foodTruckProjet.foodTruck.model.Utilisateur;
import com.foodTruckProjet.foodTruck.repo.ContactRepositery;
import com.foodTruckProjet.foodTruck.repo.ProduitRepository;
import com.foodTruckProjet.foodTruck.repo.TypeRepository;
import com.foodTruckProjet.foodTruck.repo.UtilisateurRepository;





@RestController
public class ControllerFoodTruck {

	@Autowired
	private ProduitRepository prepo;

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

	@GetMapping(path="/", produces = "application/json")
    public List<Produit> getEmployees() 
    {
        return prepo.findAll();
    }
	
	@RequestMapping("/catalogue")
	public ModelAndView catalogue(Model model) {
		ModelAndView modelAndView = new ModelAndView("catalogue", "catalogue", prepo.findAll());
		return modelAndView;
	}
	@GetMapping("/connexion")
	public ModelAndView connectionGet(Model model, HttpServletRequest ht)
	{
		ModelAndView modelAndView = new ModelAndView("connexion", "email", "");
		modelAndView.addObject("pwd","");	
		return modelAndView;
	}

	@PostMapping("/connexion")
	public ModelAndView connectionPost(@RequestParam(name="email") String email,@RequestParam(name="pwd") String mdp,Model model, HttpServletRequest ht)
	{
		ModelAndView reussite = new ModelAndView("accueil");
		ModelAndView echec = new ModelAndView("/connexion");
		Utilisateur a = userRepo.findByEmailAndMotDePasse(email, mdp);
		
		if(a!=null)
		{
			ht.getSession().setAttribute("utilisateur", a);
			ht.getSession().setAttribute("erreur", 0);
			return reussite;	
		}
		else
		{
			ht.getSession().setAttribute("erreur", 1);
			return echec;
		}
	}
	
	@GetMapping("/deconnexion")
	public ModelAndView getDeconnexion(Model model, HttpServletRequest ht)
	{
		ModelAndView modelAndView = new ModelAndView("deconnexion");
		ht.getSession().setAttribute("utilisateur",null);

		ht.getSession().invalidate();
		return modelAndView;
	}
	
	@PostMapping("/deconnexion")
	public ModelAndView deconnexionValide(Model model, HttpServletRequest ht)
	{
		ModelAndView modelAndView = new ModelAndView("deconnexion");
		ht.getSession().invalidate();
		ht.getSession().setAttribute("utilisateur",null);

		ht.getSession().invalidate();
		
		 return modelAndView ;
	}
	

	@GetMapping("/contacts")
	public ModelAndView contacts(Model model) {
		ModelAndView modelAndView = new ModelAndView("contacts");
		
		return modelAndView;
	}
	@PostMapping("/contacts")
	public ModelAndView contactes(Model model,@ModelAttribute(name="personneModel") Contact pe,HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("contacts");
		
		//ht.getSession().setAttribute("personne", pe);
		//System.out.println(pe);
		cRepo.save(pe);
		
		return modelAndView;
		
		
		
	}

	@PostMapping("/inscription")
	public ModelAndView inscription(Model model ,@ModelAttribute(name="personneModel") Utilisateur pe,HttpServletRequest ht)
	{
		ModelAndView modelAndView = new ModelAndView("inscription");
		
		ht.getSession().setAttribute("personne", pe);
		userRepo.save(pe);
	
		return modelAndView;
	}
	
	@GetMapping("/inscription")
	public ModelAndView inscrire(Model model) {
		ModelAndView modelAndView = new ModelAndView("inscription");
		Utilisateur user = new Utilisateur();
		model.addAttribute("user",user);
		return modelAndView;
	}

	@RequestMapping("/panier")
	public ModelAndView panier(Model model) {
		ModelAndView modelAndView = new ModelAndView("panier");
		return modelAndView;
	}

	@RequestMapping("/valider")
	public ModelAndView valider(Model model) {
		ModelAndView modelAndView = new ModelAndView("valider");
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

	
	@RequestMapping("profil/historique")
	public ModelAndView profilHistorique(Model model) {
		ModelAndView modelAndView = new ModelAndView("profil/historique");
		return modelAndView;
	}

	@GetMapping("/modifier")
	public ModelAndView profilModifier(Model model) {
		ModelAndView modelAndView = new ModelAndView("profil/modifier");
		//Utilisateur user = new Utilisateur();
		//model.addAttribute("user",user);
		return modelAndView;
	}
	
	@PostMapping("/modifier")
	public ModelAndView profilModifier(Model model,@ModelAttribute(name="userModel") Utilisateur pe,HttpServletRequest ht) 
	{
		Utilisateur user;
		ModelAndView modelAndView = new ModelAndView("profil/modifier");
		//ht.getSession().setAttribute("personne", pe);
		user=(Utilisateur) ht.getSession().getAttribute("utilisateur");
		//user=(Utilisateur) model.getAttribute("user");
		user.setAdresse(pe.getAdresse());
		
		if(pe.getDateDeNaissance()!=null)
		{
		user.setDateDeNaissance(pe.getDateDeNaissance());
		}
		else
		{
			user.setDateDeNaissance(user.getDateDeNaissance());
		}
		
		
		if(pe.getEmail()!="")
		{
		user.setEmail(pe.getEmail());
		}
		else
		{
			user.setEmail(user.getEmail());
		}
		
		
		
		if(pe.getGenre()!="")
		{
		user.setGenre(pe.getGenre());
		}
		else
		{
			user.setGenre(user.getGenre());
		}
		
		
		
		if(pe.getMotDePasse()!="")
		{
		user.setMotDePasse(pe.getMotDePasse());
		}
		else
		{
			user.setMotDePasse(user.getMotDePasse());
		}
		
		
		
		if(pe.getNom()!="")
		{
		user.setNom(pe.getNom());
		}
		else
		{
			user.setNom(user.getNom());
		}
		
		
		
		if(pe.getPrenom()!="")
		{
		user.setPrenom(pe.getPrenom());
		}
		else
		{
			user.setPrenom(user.getPrenom());
		}
		
		
		
		if(pe.getSociete()!="")
		{
		user.setSociete(pe.getSociete());
		}
		else
		{
			user.setSociete(user.getSociete());
		}
		
		
		userRepo.saveAndFlush(user);
		System.out.println(user);
		
		//userRepo.save(pe);
		
		
		return modelAndView;
	}
	
	

	@GetMapping("admin")
	public ModelAndView admin(Model model, HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("admin/authadmin","email", "");
		modelAndView.addObject("pwd","");
		return modelAndView;
		
		
			
	}
	@PostMapping("admin")
	public ModelAndView admine(@RequestParam(name="email") String email,@RequestParam(name="pwd") String mdp,Model model, HttpServletRequest ht)
	
{
		ModelAndView echec  = new ModelAndView("admin/authadmin");
		ModelAndView reussite = new ModelAndView("admin/homeAdmin");
		
		Utilisateur a = userRepo.findByEmailAndMotDePasse(email, mdp);
		
		
		System.out.println(a);
		
		if(a.getEmail().equals("minato@yahoo.fr")&&a.getMotDePasse().equals("admin"))
		{
			ht.getSession().setAttribute("user", a);
			ht.getSession().setAttribute("erreur", 0);
			return reussite;	
		}
		else
		{
			ht.getSession().setAttribute("erreur", 1);
			return echec;
		}
		
		
	}
	
	@GetMapping("/decon")
	public ModelAndView getDeconnexionAdmin(Model model, HttpServletRequest ht)
	{
		ModelAndView modelAndView = new ModelAndView("deconnexion");
		ht.getSession().setAttribute("user",null);

		ht.getSession().invalidate();
		return modelAndView;
	}
	
	@PostMapping("/decon")
	public ModelAndView deconnexion(Model model, HttpServletRequest ht)
	{
		ModelAndView modelAndView = new ModelAndView("deconnexion");
		ht.getSession().invalidate();
		ht.getSession().setAttribute("user",null);

		ht.getSession().invalidate();
		
		 return modelAndView ;
	}
	


	@RequestMapping("admin/listUtilisateur")
	public ModelAndView adminAfficherUtilisateur(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/listUtilisateur");
		model.addAttribute("artList", userRepo.findAll());
		return modelAndView;
	}
	
	@RequestMapping("/print")
	public ModelAndView adminPrintUser(Model model ,@RequestParam(name="id") int id ,HttpServletRequest ht)
	{
		ModelAndView modelAndView = new ModelAndView("admin/selectUtilisateur");
		//il peut en avoir deux email
		//model.addAttribute("artList", userRepo.findByEmail(email));
		model.addAttribute("List", userRepo.findById(id));
		
		//Utilisateur oneUser=userRepo.findById(id);
		
		//ht.getSession().setAttribute("userId", oneUser);
		//model.getAttribute("artList");
		return modelAndView;
		
	}
	
	@RequestMapping("/supp")
	public ModelAndView adminSuprUser(Model model ,@RequestParam(name="id") int id)
	{
		ModelAndView modelAndView = new ModelAndView("admin/supprimerUtilisateur");
		userRepo.deleteById(id);
		model.addAttribute("artList", userRepo.findAll());
		
		return modelAndView;
		
	}

	@RequestMapping("/modif")
	public ModelAndView admineModifierUtilisateur(Model model,@RequestParam(name="id") int id,HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("admin/modifierUtilisateur");
		//Utilisateur user = new Utilisateur();
		//model.addAttribute("user",user);
			Utilisateur oneUser=userRepo.findById(id);
		
		ht.getSession().setAttribute("userId", oneUser);
		return modelAndView;
	}
	
	
	@PostMapping("/modif")
	public ModelAndView adminModifierUtilisateur(Model model,@ModelAttribute(name="usersModel") Utilisateur pe,HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("admin/modifierUtilisateur");
		ModelAndView modelAndView2 = new ModelAndView("admin/listUtilisateur");
		Utilisateur user;

		user=(Utilisateur) ht.getSession().getAttribute("userId");
		
			//user.setAdresse(pe.getAdresse());
		System.out.println("seul"+pe);
		System.out.println("avant"+user);
			if(pe.getDateDeNaissance()!=null)
		{
		user.setDateDeNaissance(pe.getDateDeNaissance());
		}
			else
		{
			user.setDateDeNaissance(user.getDateDeNaissance());
		}

			
			if(pe.getEmail()!="")
			{
			user.setEmail(pe.getEmail());
			}
		else
		{
			user.setEmail(user.getEmail());
		}
		
			
			if(pe.getGenre()!="")
			{
			user.setGenre(pe.getGenre());
			}
			else
		{
			user.setGenre(user.getGenre());
			}
			
		if(pe.getMotDePasse()!="")
		{
			user.setMotDePasse(pe.getMotDePasse());
			}
			else
			{
				user.setMotDePasse(user.getMotDePasse());
		}
		
		if(pe.getNom()!="")
		{
			user.setNom(pe.getNom());
		}
		else
			{
				user.setNom(user.getNom());
		}
		
		if(pe.getPrenom()!="")
			{
			user.setPrenom(pe.getPrenom());
		}
			else
			{
				user.setPrenom(user.getPrenom());
			}
		
		if(pe.getSociete()!="")
			{
			user.setSociete(pe.getSociete());
			}
			else
			{
				user.setSociete(user.getSociete());
			}
			
			userRepo.saveAndFlush(user);
			System.out.println("apres"+user);
			
			model.addAttribute("artList", userRepo.findAll());
			return modelAndView2;
		 
		

	}

	@RequestMapping("admin/ajouterUtilisateur")
	public ModelAndView adminAjouterUtilisateur(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/ajouterUtilisateur");
		return modelAndView;
	}
	@PostMapping("admin/ajouterUtilisateur")
	public ModelAndView adminAjouterUtilisateurs(Model model ,@ModelAttribute(name="userModel") Utilisateur pe,HttpServletRequest ht)
	{
		ModelAndView modelAndView = new ModelAndView("admin/ajouterUtilisateur");
		ModelAndView modelAndView2 = new ModelAndView("admin/listUtilisateur");
		
		//ht.getSession().setAttribute("personne", pe);
		
		userRepo.save(pe);
		
		
		model.addAttribute("artList", userRepo.findAll());
	
		return modelAndView2;
	}
	
	
	@RequestMapping("/supr")
	public ModelAndView adminSuprMessage(Model model ,@RequestParam(name="id") int id)
	{
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
		return modelAndView;
	}

	@RequestMapping("admin/modifierCatalogue")
	public ModelAndView adminModifierCatalogue(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/modifierCatalogue");
		return modelAndView;
	}

	
	@GetMapping("admin/ajouterCatalogue")
	public ModelAndView adminAjouterCatalogue(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/ajouterCatalogue");
		return modelAndView;
		
	}
	@PostMapping("admin/ajouterCatalogue")
	public ModelAndView adminAjouterCatalogueS(Model model,@ModelAttribute(name="catalogues") Produit pe,
			
			
			@ModelAttribute(name="ptdej")String ptdej,@ModelAttribute(name="dej")String dej,
			@ModelAttribute(name="r")String r,@ModelAttribute(name="g")String g,
			@ModelAttribute(name="lundi")String lundi,@ModelAttribute(name="mardi")String mardi,
			@ModelAttribute(name="mercredi")String mercredi,@ModelAttribute(name="jeudi")String jeudi,
			@ModelAttribute(name="vendredi")String vendredi,@ModelAttribute(name="samedi")String samedi,
			@ModelAttribute(name="dimanche")String dimanche,
			HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("admin/ajouterCatalogue");
		//pe.getType().add(t);
//		t.setNom(t.getNom());
//		t.setHeure(t.getHeure());
//		pe.getType().add(t);
//	System.out.println(pe);
//Type	user=(Type) ht.getSession().getAttribute("tpes");
//pe.getType().add( user);
//pe.getType().add( user);
//pe.getType().add( user);
//System.out.println(user);
//		System.out.println("hello");
//		prepo.save(pe);
		
		List<Type>user = new ArrayList<Type>();
		//System.out.println("affiche"+ptdej);
		//System.out.println("affiche"+ptdej.toString());
		//System.out.println("affiche1"+dej);
		//System.out.println("affiche2"+dej.toString());
		
		if(!lundi.equals(""))
			
		{
			
		}
if(!mardi.equals(""))
			
		{
			
		}

if(!mercredi.equals(""))
	
{
	
}

if(!jeudi.equals(""))
	
{
	
}

if(!vendredi.equals(""))
	
{
	
}
if(!samedi.equals(""))
	
{
	
}

if(!dimanche.equals(""))
	
{
	
}
		
		if(!ptdej.equals(""))
			
		{
			ptdej.toString();
			Type tppe =new Type(ptdej.toString(),8);
			
			tRepo.save(tppe);
			pe.getType().add(tppe);
			prepo.save(pe);
			System.out.println(ptdej);
			System.out.println(ptdej.toString());
			
			System.out.println( tppe);
			System.out.println( pe);
			
		//user.add(new Type(ptdej,8));
		}
		if(!dej.equals(""))
		{
			Type tppe =new Type(dej.toString(),10);
			
			tRepo.save(tppe);
			pe.getType().add(tppe);
			prepo.save(pe);
			System.out.println(dej);
			System.out.println(dej.toString());
			System.out.println( tppe);
			System.out.println( pe);
			
		//user.add(new Type(ptdej,8));
		}
		if(!r.equals(""))
		{
			Type tppe =new Type(r.toString(),10);
			
			tRepo.save(tppe);
			pe.getType().add(tppe);
			prepo.save(pe);
			System.out.println(r);
			System.out.println(r.toString());
			System.out.println( tppe);
			System.out.println( pe);
			
		//user.add(new Type(ptdej,8));
		}
		if(!g.equals(""))
		{
			Type tppe =new Type(g.toString(),10);
			
			tRepo.save(tppe);
			pe.getType().add(tppe);
			prepo.save(pe);
			System.out.println(g);
			System.out.println(g.toString());
			System.out.println( tppe);
			System.out.println( pe);
			
		//user.add(new Type(ptdej,8));
		}
		
		
		
		/*if(ptdej.isEmpty())
		
		System.out.println(lundi);
		System.out.println(mardi);
		System.out.println(mercredi);
		System.out.println(jeudi);*/
		return modelAndView;
		
		
			//ModelAndView modelAndView = new ModelAndView("admin/ajouterUtilisateur");
			//ModelAndView modelAndView2 = new ModelAndView("admin/listUtilisateur");
			
			//ht.getSession().setAttribute("personne", pe);
			
			//userRepo.save(pe);
			
			
			//model.addAttribute("artList", userRepo.findAll());
		
			//return modelAndView2;
		
	}
	
	@GetMapping("/type")
	public ModelAndView adminAjouterType(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/type");
		return modelAndView;
	}
	@PostMapping("/type")
	public ModelAndView adminAjouterTypes(Model model,@ModelAttribute(name="types") Type t,HttpServletRequest ht) {
		ModelAndView modelAndView = new ModelAndView("admin/type");
		
	
		//pe.getType().add(t);
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

	@RequestMapping("admin/modifierHoraire")
	public ModelAndView adminModifierHoraire(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/modifierHoraire");
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
	

}
