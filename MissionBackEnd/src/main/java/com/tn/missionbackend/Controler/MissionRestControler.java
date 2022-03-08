package com.tn.missionbackend.Controler;

import com.tn.missionbackend.Services.MissionService;
import com.tn.missionbackend.Entites.Mission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
public class MissionRestControler {
    @Autowired
    MissionService missionService;
    @PostMapping("/add-mission")
    @ResponseBody

    public Mission addMission( @Valid @RequestBody Mission m) {
        Mission mission = missionService.addMission(m);
//return mission;
        return new Mission(HttpStatus.CREATED,mission);
    }
    @GetMapping("/retrieve-mission")
  @ResponseBody

    public List<Mission> getMissionLists() {
        List<Mission> list = missionService.retriverAllMission();
        return list; }

    @DeleteMapping("/remove-mision/{mission-id}")
    @ResponseBody
    public void deleteMission(@PathVariable("mission-id") Long missionId){
    missionService.deleteMission(missionId);
}
@PutMapping("/modify-mission")
    @ResponseBody
    public Mission updateMission(@RequestBody Mission mission)
{
    return missionService.updateMission(mission);
}
}


