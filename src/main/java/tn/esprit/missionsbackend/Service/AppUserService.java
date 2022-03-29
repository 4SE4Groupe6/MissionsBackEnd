package tn.esprit.missionsbackend.Service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.missionsbackend.Entity.AppUser;
import tn.esprit.missionsbackend.Entity.ConfirmationToken;
import tn.esprit.missionsbackend.Repository.AppUserRepository;
import tn.esprit.missionsbackend.Repository.ConfirmationTokenRepository;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Slf4j
@Service @Data
public class AppUserService implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByUsername(username);
        if(user == null){
            log.error("user not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else{
            log.info("user found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getRole().name()));});
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }


/*
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
*/

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
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            appUserRepository.save(user);

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("amirbrd13@gmail.com");
            mailMessage.setText("This is your account confirmation token : "+confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);

            result.put("A verification link has been sent in order to activate your account !", user);
        }

        return result;

    }

    public String confirmationUserAccount(String confirmationToken){
        String message ="";
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if (token!=null){
            AppUser user = appUserRepository.findByUsername(token.getUser().getUsername());
            user.setActive(true);
            appUserRepository.save(user);
            message = "Activated account!";
        }
        else {
                message = "error !";
        }
        return message;

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
