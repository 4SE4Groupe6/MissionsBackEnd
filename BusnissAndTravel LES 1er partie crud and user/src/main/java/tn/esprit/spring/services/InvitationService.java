package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.Repository.InvitationRepository;
import tn.esprit.spring.entities.Invitation;
@Service
public class InvitationService implements IInvitationService {
@Autowired
InvitationRepository inv ;

	@Override
	public List<Invitation> retrieveAllInvitations() {
		// TODO Auto-generated method stub
		return (List<Invitation>) inv.findAll();
	}
	@Override

	public void ajouterInvitation(Invitation invitation) {
		// TODO Auto-generated method stub
		 inv.save(invitation);
	}

	@Override
	public void deleteInvitation(Long id) {
		// TODO Auto-generated method stub
		inv.deleteById(id);
	}

	@Override
	public Invitation updateInvitation(Invitation I) {
		// TODO Auto-generated method stub
		return inv.save(I);
	}
	
	


}
