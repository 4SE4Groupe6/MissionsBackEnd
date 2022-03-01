package tn.esprit.missionsbackend.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.missionsbackend.Entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByRole (String role);

}
