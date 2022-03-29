package tn.esprit.spring.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.InvitationRepository;
import tn.esprit.spring.entities.Invitation;
@Service

public class InvitationUserService implements IinvitationUser  {

	@Autowired 
	InvitationService invv;
	@Autowired
	InvitationRepository inr;

	
	public String stat(String MetierEmploye) {
		
		List<Invitation> lm = invv.retrieveAllInvitations();
		
		float i = 0 ;
		for (Invitation invitation : lm) {
			
			if (invitation.getMetierEmploye().toUpperCase().equals(MetierEmploye.toUpperCase()))
				
				i=i+1;
		}
		float percent = (i/lm.size())*100;
		
		return "Pourcentage de cette Metier: "+MetierEmploye+" est égale a : "+percent;		
		

	}


	@Override
	public List<Invitation> allEmployeAjouter() {
		// TODO Auto-generated method stub
		return  (List<Invitation>) inr.findAll();
	}



}
