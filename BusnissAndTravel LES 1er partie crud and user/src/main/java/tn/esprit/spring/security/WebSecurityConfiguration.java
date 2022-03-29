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
	@SuppressWarnings("unused")
	@Override

	protected void configure(HttpSecurity http) throws Exception {
		String[] statiStrings  =  {
				"/css/**",
				"/images/**",
				"/fonts/**",
				"/scripts/**",
		};
	http.authorizeRequests() .antMatchers("/registration").permitAll()
	.antMatchers("/getRevenuBrutProduit/{idProduit}/{startDate}/{endDate}").access("hasRole('SUPERADMIN')")
	.antMatchers("/get**}").access("hasRole('ADMIN')")
	.antMatchers("/invitation/**").permitAll()
	.antMatchers("/addph/**").permitAll()
	.antMatchers("/SpringSecurity/**").permitAll()
	.antMatchers("/uploadPictureToUser/**").permitAll()
	.antMatchers("/uploadPictureToInvitation/**").permitAll()
	.antMatchers("/uploadPicture/**").permitAll()
	.antMatchers("/css/**").permitAll()
	.antMatchers("/images/**").permitAll()
	.antMatchers("/api/**").permitAll()
	.antMatchers("/sendEmail/**").permitAll()
	.antMatchers("/sendEmailwithAttachmentss/**").permitAll()
	.antMatchers("/add/**").permitAll()
	.antMatchers("/stat/gfffff**").permitAll()
	.antMatchers("/gfffff/**").permitAll()

	.antMatchers("/stat/{employe}**").permitAll()
	.antMatchers("/stat/***").permitAll()

	.antMatchers("/home/**").permitAll()

	.antMatchers("/retrieve-all-clients").access("hasRole('ADMIN')")
	.anyRequest()
	.authenticated()
	.and()
	.httpBasic().and().csrf().disable();
	}}
