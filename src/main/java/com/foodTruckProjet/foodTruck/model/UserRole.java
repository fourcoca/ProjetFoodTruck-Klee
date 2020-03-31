package  com.foodTruckProjet.foodTruck.model;

import javax.persistence.*;

@Entity
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Utilisateur utilisateur;

	@Enumerated(EnumType.STRING)
	private Role role;

	public UserRole() {
	}

	public UserRole(Utilisateur utilisateur, Role role) {
		super();
		this.utilisateur = utilisateur;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
