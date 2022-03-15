package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import tn.esprit.spring.entities.Role;

public interface UserDetailsService {
	 UserDetails loadUserByUsername(String userName);
	 List<GrantedAuthority> getUserAuthority(Set<Role> userRoles);
}
