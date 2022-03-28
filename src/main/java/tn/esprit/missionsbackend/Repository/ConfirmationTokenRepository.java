package tn.esprit.missionsbackend.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.missionsbackend.Entity.ConfirmationToken;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}