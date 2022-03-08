package com.tn.missionbackend.Services;
import com.tn.missionbackend.Entites.Mission;

import java.util.Date;
import java.util.List;

public interface IMission {
    Mission addMission(Mission m);

   void deleteMission(long id);

   Mission updateMission(Mission m);
 //  List<Mission> getAllMissionsByEmployee(Long id);

  List<Mission> retriverAllMission();

}

