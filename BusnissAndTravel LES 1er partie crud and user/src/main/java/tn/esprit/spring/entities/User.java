package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@Entity
@SuppressWarnings("serial")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idU;
	private String userName;
	private String email; 
	private String password;
	private String name;
	private String lastName;
	private String PicturePath;
	private String Picture;
	//tu peux accider au site si seullement si vous activer apartir d'un lien qui envoyer sur email
	private Boolean active;
	@ManyToMany(cascade = CascadeType.PERSIST,
			fetch = FetchType.EAGER)
			private Set<Role> roles;


	
}
