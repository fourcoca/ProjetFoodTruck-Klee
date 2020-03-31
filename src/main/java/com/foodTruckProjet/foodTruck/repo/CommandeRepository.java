package com.foodTruckProjet.foodTruck.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foodTruckProjet.foodTruck.model.Commande;
 	
public interface CommandeRepository extends JpaRepository<Commande, Integer>{

}
