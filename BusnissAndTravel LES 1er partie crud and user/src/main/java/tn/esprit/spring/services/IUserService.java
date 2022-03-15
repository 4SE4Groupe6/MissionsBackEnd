package tn.esprit.spring.services;

import tn.esprit.spring.entities.User;

public interface IUserService {
	User findUserByUserName(String userName);
	User saveUser(User user) ;
}
