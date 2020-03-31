package com.foodTruckProjet.foodTruck.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foodTruckProjet.foodTruck.model.UserRole;
import com.foodTruckProjet.foodTruck.model.Utilisateur;
 	
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{

	UserRole findByUtilisateur(Utilisateur utilisateur);
}
