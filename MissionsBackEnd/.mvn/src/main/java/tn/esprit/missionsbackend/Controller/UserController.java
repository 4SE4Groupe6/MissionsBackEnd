package tn.esprit.missionsbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.missionsbackend.Entity.User;
import tn.esprit.missionsbackend.Service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registration")
    private String registrationUser (@RequestBody User user){
        userService.registrationUser(user);
        return ("User has been successfully registered !");
    }

    /*@PutMapping("/update/{idUser}")
    private String updateUser(@RequestBody User user,@PathVariable("idUser") Long idUser){
        userService.updateUser(user, idUser);
        return ("User has been successfully updated !");
    }*/

    @GetMapping("/users")
    private List<User> displayUsers(){
        return userService.displayUsers();
    }

    @GetMapping("/details/{idUser}")
    private User userDetails(@PathVariable("idUser") Long idUser){
        return userService.userDetails(idUser);
    }

    @DeleteMapping("/delete/{idUser}")
    private String deleteUser(@PathVariable("idUser")Long idUser){
        userService.deleteUser(idUser);
        return ("User has been successfully deleted !");
    }

}
