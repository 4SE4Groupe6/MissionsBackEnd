package com.tn.missionbackend.Entites;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String nom;

    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne(cascade = CascadeType.ALL)
   private Mission mission;
}