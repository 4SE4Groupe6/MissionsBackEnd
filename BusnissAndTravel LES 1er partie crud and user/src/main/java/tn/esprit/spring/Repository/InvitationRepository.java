package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Invitation;

public interface InvitationRepository extends CrudRepository<Invitation,Long> {

}
