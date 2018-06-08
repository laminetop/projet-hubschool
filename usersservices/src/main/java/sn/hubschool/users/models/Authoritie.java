package sn.hubschool.users.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "Authoritie")
@Data
public final class Authoritie implements Serializable {




    @Id
    @GeneratedValue
    private Long id;


    @Column(nullable = false)
    private String authority;







}
