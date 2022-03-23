package com.tn.missionbackend.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.tn.missionbackend.Entites.Mission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MissionRepository extends CrudRepository<Mission, Long> {
    @Query("select m FROM Mission m Where m.start_date between :d1 and :d2")
    public List<Mission> retrieveClientsByDateIntervale(@Param("d1") Date From, @Param("d2") Date to);

}
