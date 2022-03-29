package tn.esprit.spring.Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.Repository.InvitationRepository;
import tn.esprit.spring.entities.Invitation;
import tn.esprit.spring.services.IInvitationService;

@RestController
@RequestMapping("/invitation")

public class InvitationController {
@Autowired
IInvitationService innv ;
@Autowired
InvitationRepository inv;
@ResponseBody
@GetMapping("/AfficherInvitation")
  
public List<Invitation> getInvitation() {
	
	List<Invitation> listInvitations = innv.retrieveAllInvitations();
	return listInvitations;
	}
@ResponseBody
@PostMapping("/add")

public void addInvitation(@RequestBody Invitation i)
{
 innv.ajouterInvitation(i);
}



//http://localhost:8089/SpringMVC/invitation/remove-invitation/{invitation-id}
@DeleteMapping("/remove-invitation/{invitation-id}")
@ResponseBody
public void removeInvitation(@PathVariable("invitation-id") Long invitationId) {
	innv.deleteInvitation(invitationId);
}

//http://localhost:8089/SpringMVC/invitation/modify-invitation
@PutMapping("/modify-invitation")
@ResponseBody
public Invitation modifyInvitation(@RequestBody Invitation invitation) {
return innv.updateInvitation(invitation);
}


@ResponseBody

@PutMapping("/uploadPicture")

public Invitation uploadPictureToInvitation (@RequestParam Long invitationId, @RequestPart("file") MultipartFile file) {
	try {
		Invitation invitation = inv.findById(invitationId).orElse(null);
		if (invitation != null) {
			File directory = new File("upload//");
			if (!directory.exists())
				directory.mkdir();
			byte[] bytes = new byte[0];
			bytes = file.getBytes();
			Files.write(Paths.get("upload//" + file.getOriginalFilename()), bytes);
			invitation.setPicture(Paths.get("upload//" + file.getOriginalFilename()).toString());
			return inv.save(invitation);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}















}
