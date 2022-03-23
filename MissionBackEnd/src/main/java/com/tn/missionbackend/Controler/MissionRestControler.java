package com.tn.missionbackend.Controler;

import com.tn.missionbackend.Repository.MissionRepository;
import com.tn.missionbackend.Services.MissionService;
import com.tn.missionbackend.Entites.Mission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import org.springframework.http.ResponseEntity;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Value;

@RestController
public class MissionRestControler {
    @Autowired
    MissionService missionService;
    @Autowired
    MissionRepository missionRepository;

    @PostMapping("/add-mission")
    @ResponseBody

    public Mission addMission(@Valid @RequestBody Mission m) {
        Mission mission = missionService.addMission(m);
//return mission;
        return new Mission(HttpStatus.CREATED, mission);
    }

    @GetMapping("/retrieve-mission")
    @ResponseBody

    public List<Mission> getMissionLists() {
        List<Mission> list = missionService.retriverAllMission();
        return list;
    }

    @DeleteMapping("/remove-mision/{mission-id}")
    @ResponseBody
    public void deleteMission(@PathVariable("mission-id") Long missionId) {
        missionService.deleteMission(missionId);
    }

    @PutMapping("/modify-mission")
    @ResponseBody
    public Mission updateMission(@RequestBody Mission mission) {

        return missionService.updateMission(mission);
    }

    @PutMapping("/uploadPicture")
    @ResponseBody
    public Mission uploadPictureToMission(@RequestParam Long missionId, @RequestPart("file") MultipartFile file) {
        try {
            Mission mission = missionRepository.findById(missionId).orElse(null);
            if (mission != null) {
                File directory = new File("upload//");
                if (!directory.exists())
                    directory.mkdir();
                byte[] bytes = new byte[0];
                bytes = file.getBytes();
                Files.write(Paths.get("upload//" + file.getOriginalFilename()), bytes);
                //  mission.setPicturePath(Paths.get("upload//" + file.getOriginalFilename()).toString());
                return missionRepository.save(mission);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    String FILE_DIRECTORY;

    @PostMapping("/uploadFile")
    public ResponseEntity<Object> fileUpload(@RequestParam("File") MultipartFile file) throws IOException {
        File myFile = new File(FILE_DIRECTORY + file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        return new ResponseEntity<Object>("The File Uploaded Successfully", HttpStatus.OK);
    }
}


