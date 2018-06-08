package sn.hubschool.eleves.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by gueyealy on 02/01/2018.
 */
@Entity
@Table(name = "Tuteur")
@Data
public class Tuteur {

    @Id
    @GeneratedValue
    private Long id;

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String nomTuteur;

    @NotBlank
    @Column(nullable = false)
    private String prenomTuteur;

    @NotBlank
    @Column(nullable = false)
    private String adresse;


    @Column(nullable = false)
    private int telephone;

}
