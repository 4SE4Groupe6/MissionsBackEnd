package com.tn.missionbackend.Services;

import com.tn.missionbackend.Entites.Mission;
import com.tn.missionbackend.Repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MissionService implements IMission {
    @Autowired
    private MissionRepository missionRepository;

    @Override

    public Mission addMission(Mission m) {

        missionRepository.save(m);
        return null;
    }

    @Override
    public void deleteMission(long id) {
        missionRepository.deleteById(id);
    }

    @Override
    public Mission updateMission(Mission m) {
        return missionRepository.save(m);

    }

    // @Override
    //  public List<Mission> getAllMissionsByEmployee(Long id) {
    // List<Mission> Ms = (List<Mission>) missionRepository.findAll();
    //  return Ms;


    @Override
    public List<Mission> retriverAllMission() {
        List<Mission> Ms = (List<Mission>) missionRepository.findAll();

        return Ms;
    }


}






