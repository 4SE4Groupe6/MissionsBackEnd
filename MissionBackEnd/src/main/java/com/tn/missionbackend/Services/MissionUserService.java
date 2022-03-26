package com.tn.missionbackend.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tn.missionbackend.UserAlreadyAffecterException;
import com.tn.missionbackend.Entites.Mission;
import com.tn.missionbackend.Entites.MissionUser;
import com.tn.missionbackend.Entites.User;
import com.tn.missionbackend.Repository.MissionRepository;
import com.tn.missionbackend.Repository.MissionUserRep;
import com.tn.missionbackend.Repository.MissionUserRep;
import com.tn.missionbackend.Repository.UserRepository;


@Service
public class MissionUserService implements IMissionUser {

	@Autowired
	MissionUserRep missionUserRep ;
	
	@Autowired
	UserRepository userRepository ;
	
	@Autowired
	MissionService missionService ;
	
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private MissionRepository missionRepository;

	@Value("spring.mail.username")
	private String from;

	@Value("spring.mail.password")
	private String password;
	
	@Override
	public MissionUser AffecterMission(Long iduser, Long idMi) {
		
		User u = userRepository.findById(iduser).orElse(null);
		Mission m = missionService.findMissionById(idMi);
		MissionUser mu = new MissionUser();
		mu.setMissions(m);
		mu.setUsers(u);
		
		List<MissionUser> lm = allMissionAffecter();
		List<String> lu = new ArrayList<>();
		for (MissionUser missionu : lm) {
			
			if (missionu.getMissions().getDestination().equals(m.getDestination())) 
				
				lu.add(missionu.getUsers().getEmail());
		}
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(u.getEmail());
		message.setSubject("Test Subject");
		message.setText("Voici les employer qui ont la meme distination"+lu);
		javaMailSender.send(message);
		
		for (MissionUser muser : lm) {
			
			if (muser.getUsers() == u) {
				
	            throw new UserAlreadyAffecterException("User :'" + u.getFirstName() + "'is already affecter");
			}
			
		}
		
		return missionUserRep.save(mu);

		
	}

	@Override
	public List<MissionUser> allMissionAffecter() {
		// TODO Auto-generated method stub
		return missionUserRep.findAll();
	}

	@Override
	public void deleteMissionAffecter(long id) {
		missionUserRep.deleteById(id);
	}

	@Override
	public String stat(String destination) {
		
		List<Mission> lm = missionService.retriverAllMission();
		
		float i =0 ;
		for (Mission mission : lm) {
			
			if (mission.getDestination().toUpperCase().equals(destination.toUpperCase()))
				i=i+1;
		}
		float percent = (i/lm.size())*100;
		
		return "Pourcentage de cette distination: "+destination+" est égale a : "+percent;		
		

	}

}
