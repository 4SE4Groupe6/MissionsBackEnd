package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User,
Long> {
	// c'eST UNE METHODE COMME JPQL RT ON PEUC UTILISER CETTE METHODE JUSTE DANS METHODE SELECT
	// l metrhode ili louta t3awedh select all from user where userName=...)
User findByUserName(String userName);
}
