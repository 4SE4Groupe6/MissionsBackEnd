package com.tn.missionbackend.Entites;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Mission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMission;
    private String destination;
    private String TitleMission;
    @Temporal(TemporalType.DATE)
    private Date start_date;
    @Temporal(TemporalType.DATE)
    private Date end_date;

}