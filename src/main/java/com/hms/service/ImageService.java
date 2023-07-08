package com.hms.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hms.model.Hostelers;

import com.hms.repository.hostelersRepository;

public class ImageService {
	
	@Autowired
	private hostelersRepository hostelersRepo;
	
	private final String FOLDER_PATH = "src/main/resources/static/ProductImages/" ;
	
//    public String uploadImageToFileSystem(MultipartFile file,Hostelers hostel) throws IOException {
//        String filePath=FOLDER_PATH+file.getOriginalFilename();
//
//        Hostelers hostel1 = hostelersRepo.save(Hostelers.builder()
//                .image(file.getOriginalFilename()).build());
//
//        file.transferTo(new File(filePath));
//
//        if (hostel1 != null) {
//            return "file uploaded successfully : " + filePath;
//        }
//        return null;
//    }
}
