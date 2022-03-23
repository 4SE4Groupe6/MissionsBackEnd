package tn.esprit.missionsbackend.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.missionsbackend.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
