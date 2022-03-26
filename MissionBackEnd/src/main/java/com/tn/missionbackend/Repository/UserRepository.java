package com.tn.missionbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tn.missionbackend.Entites.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
