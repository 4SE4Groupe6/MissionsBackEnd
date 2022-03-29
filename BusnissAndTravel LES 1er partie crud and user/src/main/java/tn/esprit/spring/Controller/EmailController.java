package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.services.EmailService;

@RestController
@RequestMapping("/api")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	
	//http://localhost:8090/SpringSecurity/api/sendEmail
	@ResponseBody
	@GetMapping("/sendEmail")
	
	public String sendEmail() {
		return emailService.sendEmail();
	}
	//http://localhost:8090/SpringSecurity/api/sendEmailwithAttachment
	@ResponseBody
	@GetMapping("/sendEmailwithAttachment")
	public String sendEmailwithAttachment() {
		return emailService.sendEmailwithAttachment();
	}
	
}
