package sn.hubschool.eleves.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gueyealy on 02/01/2018.
 */
@Entity
@Table(name = "Eleve")
@Data

public class Eleve {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String adresse;

    @Temporal(TemporalType.DATE)
    private Date date_naissance;

    @Column(unique = true)
    private String matricule;

    @NotBlank
    @Column(nullable = false)
    private String nom;

    @NotBlank
    @Column(nullable = false)
    private String prenom;

    @ManyToOne
    private Tuteur tuteur;


}
