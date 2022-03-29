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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	@NotEmpty
	@Size(min=1, message="Destination shoud have at least 3 characters")
	private String userName;
	@NotEmpty
	  
    @Email(message = "Wrong e-mail")
	private String email; 
	 @NotEmpty(message = "password is required")
	@NotEmpty
	@Size(min=8, message="password shoud have at least 8 characters")
	private String password;
	@NotEmpty
	@Size(min=1, message="Destination shoud have at least 3 characters")
	private String lastName;
	private String Picture;
	//tu peux accider au site si seullement si vous activer apartir d'un lien qui envoyer sur email
	private Boolean active;
	@ManyToMany(cascade = CascadeType.PERSIST,
			fetch = FetchType.EAGER)
			private Set<Role> roles;


	
}
