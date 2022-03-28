package tn.esprit.missionsbackend.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.missionsbackend.Entity.AppUser;

import javax.transaction.Transactional;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a " +
            "SET a.active = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}
