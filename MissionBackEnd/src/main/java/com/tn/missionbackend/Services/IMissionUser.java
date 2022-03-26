package com.tn.missionbackend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tn.missionbackend.Entites.MissionUser;


public interface IMissionUser {

	MissionUser AffecterMission(Long iduser ,Long idMi);
	
	List<MissionUser> allMissionAffecter();
	public void deleteMissionAffecter(long id);
	
	public String stat (String distination);
	
	
}
