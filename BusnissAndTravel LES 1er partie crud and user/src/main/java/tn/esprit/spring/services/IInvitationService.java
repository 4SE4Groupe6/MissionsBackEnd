package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Invitation;


public interface IInvitationService {

	List<Invitation> retrieveAllInvitations();

	void ajouterInvitation(Invitation I);

	void deleteInvitation (Long id);

	Invitation updateInvitation (Invitation I);

	
}
