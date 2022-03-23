package com.tn.missionbackend.Services;

import javax.mail.MessagingException;

import org.aspectj.weaver.loadtime.Agent;
import org.springframework.mail.MailException;

import com.tn.missionbackend.Entites.Mission;



public interface MailService {

	void Send(Mission mission) throws MailException;

	void sendWithAttachment(Mission mission, Agent agent, String attachement) throws MailException, MessagingException;

	void Sendd(String email, String body, String subject);

}
