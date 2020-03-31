package com.foodTruckProjet.foodTruck.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodTruckProjet.foodTruck.model.Utilisateur;
 	
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{

	List <Utilisateur> findByEmail(String email);
	
	Utilisateur findById(int id);
	
	Utilisateur deleteByEmail(String email);
	
	Utilisateur findByNomAndPrenom(String nom,String prenom);

	Utilisateur findByEmailAndMotDePasse(String email,String mdp);
	
	Utilisateur  findByEmailNot(String email);


}
