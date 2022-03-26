package tn.esprit.missionsbackend.Service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.missionsbackend.Entity.AppUser;
import tn.esprit.missionsbackend.Repository.AppUserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service @Data
public class AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    // sign up of new user : with checking if email exists , if mail is right , if password is right

    public Map<String, AppUser> registrationUser(AppUser user) {

        Map<String, AppUser> result = new HashMap<>();
        List <AppUser> users = (List<AppUser>) appUserRepository.findAll();

        //mail form
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getEmail());

        boolean verify = false;

        for (AppUser u : users){
            if (user.getEmail().equals(u.getEmail())) {
                verify = true;
                result.put("Email Already exists !", null);
            }
        }

        if (!matcher.matches()) {
            verify=true;
            result.put("Invalid email", null);

        }

        if (!checkString(user.getPassword())){
            verify = true;
            result.put("Password must have at least 8 characters with at least 1 Upper , 1 Lower and 1 number !!", null);
        }

        if (!verify){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setActive(true);
            appUserRepository.save(user);
            result.put("user successfully signed up !", user);
        }

        return result;

    }

    // password form
    private static boolean checkString(String str) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;

        if (str.length() > 8) {
            for (int i = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if (Character.isDigit(ch)) {
                    numberFlag = true;
                } else if (Character.isUpperCase(ch)) {
                    capitalFlag = true;
                } else if (Character.isLowerCase(ch)) {
                    lowerCaseFlag = true;
                }
                if (numberFlag && capitalFlag && lowerCaseFlag)
                    return true;
            }
        }
        return false;
    }


    public void deleteUser(Long idUser){
        appUserRepository.deleteById(idUser);
    }


    public void updateUser(AppUser user, Long idUser){
        AppUser user1=appUserRepository.findById(idUser).get();

        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());

        appUserRepository.save(user1);
    }

    public List<AppUser> displayUsers(){
        List<AppUser> user = new ArrayList<AppUser>();
        appUserRepository.findAll().forEach(user1 -> user.add(user1));
        return user;
    }

    public AppUser userDetails(Long idUser){
        return appUserRepository.findById(idUser).get();
    }

}
