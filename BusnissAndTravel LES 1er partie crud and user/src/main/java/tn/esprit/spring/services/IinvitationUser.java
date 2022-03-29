package tn.esprit.spring.services;
import java.util.List;

import tn.esprit.spring.entities.Invitation;

public interface IinvitationUser {
	
	List<Invitation> allEmployeAjouter();
	public String stat(String MetierEmploye) ;	
}
