//package com.foodTruckProjet.foodTruck.conf;
// 
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import com.foodTruckProjet.foodTruck.model.Utilisateur;
//import com.foodTruckProjet.foodTruck.repo.UserRoleRepository;
//import com.foodTruckProjet.foodTruck.repo.UtilisateurRepository;
// 
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter
//{
//	@Autowired
//	private UtilisateurRepository urepo;
//	
//	@Autowired
//	private UserRoleRepository urrepo;
//	
//	 @Override
//	  public void configure(WebSecurity web) throws Exception {
//	    web
//	      .ignoring()
//	         .antMatchers("/catalogue/**"); // #3
//	  }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception 
//    {
////    	http.antMatcher("/panier").authorizeRequests().anyRequest().hasRole("USER")
////		.and().formLogin().loginPage("/connexion")
////		.failureUrl("/connexion?error=1").loginProcessingUrl("/connexion")
////		.permitAll().and().logout()
////		.logoutSuccessUrl("/accueil");
//    	
////    	http
////        .authorizeRequests()
////          .antMatchers("/connexion","/inscription","/catalogue","/accueil").permitAll() // #4
////          .antMatchers("/panier","/profil/**").hasRole("USER") // #6
////          .anyRequest().authenticated() // 7
////          .and()
////      .formLogin()  // #8
////          .loginPage("/login") // #9
////          .permitAll();
////    	
////    	http
////        .authorizeRequests()
////          .antMatchers("/admin").permitAll() // #4
////          .antMatchers("/admin/**").hasRole("ADMIN") // #6
////          .anyRequest().authenticated() // 7
////          .and()
////      .formLogin()  // #8
////          .loginPage("/admin") // #9
////          .permitAll();
////    	http.antMatcher("/profil/**").authorizeRequests().anyRequest().hasRole("USER")
////		.and().formLogin().loginPage("/connexion")
////		.failureUrl("/connexion?error=1").loginProcessingUrl("/connexion")
////		.permitAll().and().logout()
////		.logoutSuccessUrl("/accueil");
////    	
////    	http.antMatcher("/admin/**").authorizeRequests().anyRequest().hasRole("ADMIN")
////		.and().formLogin().loginPage("/connexion")
////		.failureUrl("/admin?error=1").loginProcessingUrl("/admin")
////		.permitAll().and().logout()
////		.logoutSuccessUrl("/admin/listUtilisateur");
//    }
//  
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) 
//            throws Exception 
//    {
//    	
//    	for (Utilisateur utilisateur : urepo.findAll()) {
//    		auth.inMemoryAuthentication()
//            .withUser(utilisateur.getEmail())
//            .password("{noop}"+utilisateur.getMotDePasse())
//            .roles(urrepo.findByUtilisateur(utilisateur).getRole().toString());
//		}
//    }
//}