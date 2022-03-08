package com.tn.missionbackend.Services;

import com.tn.missionbackend.Entites.Mission;
import com.tn.missionbackend.Repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;

import java.util.Date;
import java.util.List;
@Service
public class MissionService  implements IMission {
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


        @Override public List<Mission> retriverAllMission () {
            List<Mission> Ms = (List<Mission>) missionRepository.findAll();

           return Ms;
        }

    public void  saveMissionToDB(MultipartFile file, String destination, String TitleMission
            , Date start_date,Date end_date)
    {
        Mission m = new Mission();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            m.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        m.setDestination(destination);
        m.setEnd_date(end_date);
        m.setStart_date(start_date);

        missionRepository.save(m);
    }
    public List<Mission> getAllProduct()
    {
        return (List<Mission>) missionRepository.findAll();
    }
    public void deleteMissionById(Long id)
    {
        missionRepository.deleteById(id);
    }
    public void chageMissionDestinationMission(Long id ,String destination)
    {
     Mission m = new Mission();
            m = missionRepository.findById(id).get();
        m.setDestination(destination);
        missionRepository.save(m);
    }
    public void changeMissionEnd_date(Long id , Date end_date)
    {
      Mission  m= new Mission();
        m= missionRepository.findById(id).get();
        m.setEnd_date(end_date);
        missionRepository.save(m);
    }
    public void changeProductPrice(Long id,Date start_date)
    {
        Mission m = new Mission();
        m= missionRepository.findById(id).get();
        m.setStart_date(start_date);
        missionRepository.save(m);
    }
    public void chageMissionTitleMission(Long id ,String titleMission)
    {
        Mission m = new Mission();
        m = missionRepository.findById(id).get();
        m.setTitleMission(titleMission);
        missionRepository.save(m);
    }
}






