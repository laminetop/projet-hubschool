package sn.hubschool.ecoles.repos;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import sn.hubschool.ecoles.model.Ecole;

import java.util.List;


/**
 * Created by gueyealy on 10/12/2017.
 */

public interface EcoleSimpleRepository extends JpaRepository<Ecole, Long>{

    @Query("select e from Ecole e where e.nom like :x ORDER BY e.adresse")
    Page<Ecole> findAllByName(@Param("x") String mc, Pageable pageable);


    @Query("select e from Ecole e where e.nom = :x")
    Ecole findEcoleByName(@Param("x") String nom);


}
