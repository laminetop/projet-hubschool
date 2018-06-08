package sn.hubschool.ecoles.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.hubschool.ecoles.model.Classe;
import sn.hubschool.ecoles.model.Ecole;


/**
 * Created by gueyealy on 10/12/2017.
 */

public interface ClasseSimpleRepository extends JpaRepository<Classe, Long> {


    @Query("select c from Classe c where c.ecole= :x")
    Page<Classe> findByEcole(@Param("x") Ecole ecole, Pageable pageable);

}
