package sn.hubschool.users.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import sn.hubschool.users.models.User;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query("select u from User u  where u.username = :username and u.password = :password ")
    User findByUserNameAndPassword(
            @Param("username") String username,
            @Param("password") String password);


}
