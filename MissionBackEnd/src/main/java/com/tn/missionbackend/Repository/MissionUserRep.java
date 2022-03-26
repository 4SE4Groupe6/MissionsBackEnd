package com.tn.missionbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tn.missionbackend.Entites.MissionUser;
@Repository
public interface MissionUserRep extends JpaRepository<MissionUser, Long> {

}
