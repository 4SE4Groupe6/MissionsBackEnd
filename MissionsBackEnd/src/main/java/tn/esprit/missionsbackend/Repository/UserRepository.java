package tn.esprit.missionsbackend.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.missionsbackend.Entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName (String userName);
}
