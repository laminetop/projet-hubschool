package sn.hubschool.inscription.models;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import sn.hubschool.inscription.controllers.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by gueyealy on 10/12/2017.
 */
@Entity
@Table(name = "Inscription")
@Data
public class Inscription implements Serializable {

    @Id
    @GeneratedValue
    private Long id;


    @NotBlank
    @Column(nullable = false, length = 4)
    private String annee;


    @Column(nullable = false)
    private Double montant;

    @JoinTable(name = "Eleve")
    @JoinColumn(name = "id")
    @Column(nullable = false)
    private Long eleve;

    @JoinTable(name = "Classe")
    @JoinColumn(name = "id")
    @Column(nullable = false)
    private Long classe;


    private Date date;

    @Column(nullable = false)
    private Status status;



}
