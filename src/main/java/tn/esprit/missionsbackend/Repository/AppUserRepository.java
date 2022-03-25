package tn.esprit.missionsbackend.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.missionsbackend.Entity.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {

}
