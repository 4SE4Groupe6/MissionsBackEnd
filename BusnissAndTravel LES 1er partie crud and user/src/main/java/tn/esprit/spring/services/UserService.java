package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entities.User;
@Service

public class UserService implements IUserService {
@Autowired
private UserRepository userRepository;

BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

public User findUserByUserName(String userName) {
return userRepository.findByUserName(userName);
}
//le cryptage d'un mot de passe
public User saveUser(User user) {
user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
user.setActive(false);
return userRepository.save(user);
}
}