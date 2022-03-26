package com.tn.missionbackend.Entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MissionUser {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idaffecter ;
    @ManyToOne
    @JoinColumn(name="id_user",referencedColumnName = "idUser")
    private User  users;
    @ManyToOne
    @JoinColumn(name="id_Etage",referencedColumnName = "idMission")
    private Mission missions;
    
    
    
    
	public MissionUser() {
		super();
	}
	public Long getIdaffecter() {
		return idaffecter;
	}
	public void setIdaffecter(Long idaffecter) {
		this.idaffecter = idaffecter;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Mission getMissions() {
		return missions;
	}
	public void setMissions(Mission missions) {
		this.missions = missions;
	}

}
