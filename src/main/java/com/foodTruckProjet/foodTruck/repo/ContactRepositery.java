package com.foodTruckProjet.foodTruck.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodTruckProjet.foodTruck.model.Contact;
import com.foodTruckProjet.foodTruck.model.Utilisateur;

public interface ContactRepositery  extends JpaRepository<Contact, Integer>{

	


}
