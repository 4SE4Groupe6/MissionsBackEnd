package com.tn.missionbackend.Entites;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Lob;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Mission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMission;
    @NotEmpty
    @Size(min = 5, message = "destination should have at least 2 characters")
    private String destination;
    @NotEmpty
    private String TitleMission;
    private String picture;
    //private String PicturePath;
    @Temporal(TemporalType.DATE)
    private Date start_date;
    @Temporal(TemporalType.DATE)
    private Date end_date;

    public Mission(HttpStatus created, Mission mission) {
    }

    public Mission() {

    }
}