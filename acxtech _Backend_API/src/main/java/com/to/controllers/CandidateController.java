package com.to.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.to.entity.Candidate;
import com.to.jwt.util.JwtUtil;
import com.to.service.CandidateServiceImpl;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/candidate")
public class CandidateController {
	
	@Autowired
	CandidateServiceImpl service;
	
	 @Autowired
	 private JwtUtil jwtUtil;
	 
	@GetMapping
	public List<Candidate> getCandidates(HttpServletRequest httpServletRequest) {
	    //extracting the current user name from the jwt token	
		String authorizationHeader = httpServletRequest.getHeader("Authorization");
        String token = null;
        String userName = null;
            token = authorizationHeader.substring(7);
            userName = jwtUtil.extractUsername(token);
        System.out.println("User Name: "+userName);
          return service.getCandidates(userName);      	
	}
	

	@PostMapping
	public Candidate saveCandidate(HttpServletRequest httpServletRequest,@RequestParam("file") MultipartFile file,@RequestParam("candidate") String can) {
		System.out.println("cadidate controller called");
		
		//extracting the current user name from the jwt token	
				String authorizationHeader = httpServletRequest.getHeader("Authorization");
		        String token = null;
		        String userName = null;
		            token = authorizationHeader.substring(7);
		            userName = jwtUtil.extractUsername(token);
		//finding the user id
		  int uid=  service.getCurrentUserId(userName);		
		Candidate c=null;		
		
		try {
			//converting the product string details in the product entity
			c=new ObjectMapper().readValue(can,Candidate.class);
			//saving the file 
			File saveFile=new ClassPathResource("").getFile();
			Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
			System.out.println("File path is :"+path);
			Files.copy(file.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);		
			System.out.println("File Saved Successfully");
			
			//setting the file name into the db
			c.setPhotoPath(path.toString());
			//setting the current user id
			c.setUid(uid);
			
		}	catch (Exception e) {
			System.out.println("Error While Saving the file"+e.toString());
		}
		//System.out.println(c.toString());
		System.out.println(file.getOriginalFilename());
		
	     return service.saveCandidate(c);		
	     
	}
	

}
