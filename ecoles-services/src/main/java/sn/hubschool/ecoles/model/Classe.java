package sn.hubschool.ecoles.model;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "Classe")
@Data
public class Classe implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = true)
    private String nom;


    @Column(nullable = false)
    private int capacite;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private Ecole ecole;

}
