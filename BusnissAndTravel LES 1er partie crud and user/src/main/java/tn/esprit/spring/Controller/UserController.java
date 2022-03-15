 package tn.esprit.spring.Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entities.User;


@RestController

public class UserController {
 @Autowired
 UserRepository userr;
 
 

@ResponseBody
@PutMapping("/uploadPictureToUser")
public User uploadPictureToUser(@RequestParam Long userId,
		@RequestPart("file") MultipartFile file) {
	try {
		User user = userr.findById(userId).orElse(null);
		if (user != null) {
			File directory = new File("upload//");
			if (!directory.exists())
				directory.mkdir();
			byte[] bytes = new byte[0];
			bytes = file.getBytes();
			Files.write(Paths.get("upload//" + file.getOriginalFilename()), bytes);
		user.setPicturePath(Paths.get("upload//" + file.getOriginalFilename()).toString());
			return userr.save(user);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}
}
