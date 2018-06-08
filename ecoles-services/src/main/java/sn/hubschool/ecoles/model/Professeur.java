package sn.hubschool.ecoles.model;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by gueyealy on 10/12/2017.
 */
@Entity
@Table(name = "Professeur")
@Data
public class Professeur implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nom;

    @NotBlank
    @Column(nullable = false)
    private String prenom;

    @NotBlank
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String adresse;


    @Column(nullable = false)
    private int telephone;

    @ManyToOne
    private Ecole ecole;

}
