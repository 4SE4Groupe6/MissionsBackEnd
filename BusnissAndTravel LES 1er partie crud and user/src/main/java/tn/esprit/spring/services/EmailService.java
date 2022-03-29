package tn.esprit.spring.services;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;

	//http://localhost:8090/SpringSecurity/api/sendEmail
	public String sendEmail() {
		
	    SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("lesnomades512022@gmail.com");
		message.setTo("wiem.ifaoui@esprit.tn");
		message.setSubject("Test Subject");
		message.setText("Test Body");
		
		
		javaMailSender.send(message);
		
		return "Mail sent successfully";
	}
	//http://localhost:8090/SpringSecurity/api/sendEmailwithAttachment
	
	public String sendEmailwithAttachment() {
		
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			
			MimeMessageHelper messageHelper = 
					new MimeMessageHelper(message, true);
			
			messageHelper.setFrom("lesnomades512022@gmail.com");
			messageHelper.setTo("wiem.ifaoui@esprit.tn");
			messageHelper.setSubject("Test Subject");
			messageHelper.setText("Test Body");
			
			File file = new File("C:\\temp\\hello.txt");
			
			messageHelper.addAttachment(file.getName(), file);
			
			javaMailSender.send(message);
			
			return "Mail sent successfully";
			
		} catch (Exception e) {
			return "Mail sent failed";
		}
	}
}
