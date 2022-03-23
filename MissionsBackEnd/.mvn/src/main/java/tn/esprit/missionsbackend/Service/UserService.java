package tn.esprit.missionsbackend.Service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.missionsbackend.Entity.User;
import tn.esprit.missionsbackend.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service @Data
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void registrationUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(Long idUser){
        userRepository.deleteById(idUser);
    }

    /*public void updateUser(User user, Long idUser){
        User user = userRepository.findById(idUser);
        user.setFirstName(userDetails(idUser).getFirstName());
        user.setLastName(userDetails(idUser).getLastName());
        user.setEmail(userDetails(idUser).getEmail());
        user.setPassword(userDetails(idUser).getPassword());

        User user = userRepository.saver(user);

    }*/

    public List<User> displayUsers(){
        List<User> user = new ArrayList<User>();
        userRepository.findAll().forEach(user1 -> user.add(user1));
        return user;
    }

    public User userDetails(Long idUser){
        return userRepository.findById(idUser).get();
    }

}
