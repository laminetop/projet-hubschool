package sn.hubschool.ecoles.model;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by gueyealy on 10/12/2017.
 */
@Entity
@Table(name = "Ecole")
@Data
public class Ecole implements Serializable{

    @Id
   @GeneratedValue
    private Long id;


    @Column(nullable = false)
    private String nom;



    @Column(nullable = false)
    private String adresse;


    // Cycle de l'ecole

    @Column(nullable = false)
    private String typeecole;





}
