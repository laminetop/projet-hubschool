package sn.hubschool.users.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.hubschool.users.Repository.UserRepository;
import sn.hubschool.users.models.AppUser;
import sn.hubschool.users.models.User;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UserService {




        @Autowired
        private UserRepository userRepository;

/*
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<AppUser> listerUsers(){

        return userRepository.findAll();
    }

*/
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public  AppUser save(@RequestBody AppUser user){

        return userRepository.save(user);
    }


/*
    @RequestMapping(value="/login")
    public User chercherUser(@RequestParam(name = "username") String username,
                                      @RequestParam(name = "password") String password)
    {
        return userRepository.findByUserNameAndPassword(username,password);
    } */


}
