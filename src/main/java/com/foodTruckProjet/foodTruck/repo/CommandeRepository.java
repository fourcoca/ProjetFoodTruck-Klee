package com.foodTruckProjet.foodTruck.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodTruckProjet.foodTruck.model.Commande;
import com.foodTruckProjet.foodTruck.model.Utilisateur;
 	
public interface CommandeRepository extends JpaRepository<Commande, Integer>{

	List<Commande> findByUtilisateur(Utilisateur current);

}
