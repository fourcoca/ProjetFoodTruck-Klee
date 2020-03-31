//package com.foodTruckProjet.foodTruck.services;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.foodTruckProjet.foodTruck.model.Utilisateur;
//import com.foodTruckProjet.foodTruck.repo.UtilisateurRepository;
//
//@Service("utilisateurService")
//public class UtilisateurService implements UserDetailsService {
//
//    private final UtilisateurRepository utilisateurRepository;
//
//    @Autowired
//    public UtilisateurService(UtilisateurRepository userRepository) {
//        this.utilisateurRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//    	Utilisateur user = utilisateurRepository.findByEmail(email);
//        if (user == null) {
//            throw new UsernameNotFoundException("Pas d'utilisateur avec le mail suivant : " + email);
//        }
//        else {
//            return user;
//        }
//    }
//}