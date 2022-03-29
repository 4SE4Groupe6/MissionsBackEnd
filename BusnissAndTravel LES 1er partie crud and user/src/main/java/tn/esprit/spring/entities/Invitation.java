package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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

public class Invitation implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	long invitationId;
	@NotEmpty
	@Size(min=3, message="job Employ shoud have at least 3 characters")
	String MetierEmploye;
	@Size(min=3, message="Destination shoud have at least 3 characters")
	String Recepteur;
	@Temporal(TemporalType.DATE)
    @DateTimeFormat ( pattern = "aaaa-MM-jj" )
    @NotNull ( message = "Veuillez indiquer une date." )
	Date date; 
	String picture;


}
