package tn.esprit.missionsbackend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Enumerated(EnumType.STRING)
        private theRole role;

}
