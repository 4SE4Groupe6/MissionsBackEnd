package tn.esprit.missionsbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.missionsbackend.Entity.AppUser;
import tn.esprit.missionsbackend.Repository.ConfirmationTokenRepository;
import tn.esprit.missionsbackend.Service.AppUserService;
import tn.esprit.missionsbackend.Service.EmailSenderService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AppUserController {

//----------------------------------------------------------------------------------------------------------------------

    @Autowired
    AppUserService userService;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private EmailSenderService emailSenderService;

//----------------------------------------------------------------------------------------------------------------------

    @PostMapping("/registration")
    @ResponseBody
    private Map<String, AppUser> registrationUser (@RequestBody AppUser user){
        return userService.registrationUser(user);
    }

//----------------------------------------------------------------------------------------------------------------------

    @PostMapping("/confirmationRegistration")
    @ResponseBody
    private String verificationAccount (@RequestParam("token") String confirmationToken){
        return userService.confirmationUserAccount(confirmationToken);
    }

//----------------------------------------------------------------------------------------------------------------------

    @PutMapping("/update/{idUser}")
    private String updateUser(@RequestBody AppUser user, @PathVariable("idUser") Long idUser){
        userService.updateUser(user, idUser);
        return ("User has been successfully updated !");
    }

//----------------------------------------------------------------------------------------------------------------------

    @GetMapping("/users")
    private List<AppUser> displayUsers(){
        return userService.displayUsers();
    }

//----------------------------------------------------------------------------------------------------------------------

    @GetMapping("/details/{idUser}")
    private AppUser userDetails(@PathVariable("idUser") Long idUser){
        return userService.userDetails(idUser);
    }

//----------------------------------------------------------------------------------------------------------------------

    @DeleteMapping("/delete/{idUser}")
    private String deleteUser(@PathVariable("idUser") Long idUser){
        userService.deleteUser(idUser);
        return ("User has been successfully deleted !");
    }






}
