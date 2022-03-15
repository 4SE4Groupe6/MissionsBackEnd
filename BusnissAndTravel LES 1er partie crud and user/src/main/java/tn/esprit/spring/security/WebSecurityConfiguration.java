package tn.esprit.spring.security;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tn.esprit.spring.services.MyUserDetailsService;
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests() .antMatchers("/registration").permitAll()
	.antMatchers("/getRevenuBrutProduit/{idProduit}/{startDate}/{endDate}").access("hasRole('SUPERADMIN')")
	.antMatchers("/get**}").access("hasRole('ADMIN')")
	.antMatchers("/invitation/**").permitAll()
	.antMatchers("/uploadPictureToUser/**").permitAll()
	
	.antMatchers("/SpringSecurity/**").permitAll()

	.antMatchers("/retrieve-all-clients").access("hasRole('ADMIN')")
	.anyRequest()
	.authenticated()
	.and()
	.httpBasic().and().csrf().disable();
	}}
