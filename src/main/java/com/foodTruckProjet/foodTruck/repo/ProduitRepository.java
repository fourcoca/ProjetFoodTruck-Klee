package com.foodTruckProjet.foodTruck.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodTruckProjet.foodTruck.model.Produit;
 	
public interface ProduitRepository extends JpaRepository<Produit, Integer>{

	@Query(
			  value = "SELECT produit.* FROM commande_lignes,ligne,produit WHERE commande_lignes.lignes_id=ligne.id and ligne.produit_id=produit.id GROUP BY nom ORDER BY SUM(quantite) DESC LIMIT 3;", 
			  nativeQuery = true)
	List<Produit> findtop3();

}
