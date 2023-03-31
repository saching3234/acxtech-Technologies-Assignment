package com.to.controllers;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.to.entity.AuthRequest;
import com.to.entity.User;
import com.to.error.InvalidUserNamePasswordException;
import com.to.error.UserIdAllReadyExist;
import com.to.jwt.util.JwtUtil;
import com.to.service.CustomUserDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private  CustomUserDetailsService userService;  
    
   
    
    //method for handing the user registration
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> registerUser(@RequestBody User user) throws UserIdAllReadyExist, InvalidUserNamePasswordException {
      // System.out.println("register called");
    	User newUser=	userService.registerUser(user);
    	Map<String,String> map=new HashMap<>();
    	String tokenString= generateTocken(newUser.getUserName(), newUser.getPassword());
    	 map.put("token", tokenString);
         return map;
    }
    
    
    
    //method for handling the login
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String, String> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
    	Map<String,String> map=new HashMap<>();
    	//System.out.println("login called "+authRequest.toString());
        String tokenString= generateTocken(authRequest.getUserName(), authRequest.getPassword());
         map.put("token", tokenString);
        return map;
    }
    
     
     //method for generating the jwt token
    String generateTocken(String userName,String password) throws InvalidUserNamePasswordException {
    	try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userName, password)
            );
        } catch (Exception ex) {
            throw new InvalidUserNamePasswordException("inavalid username/password");
        }
        return jwtUtil.generateToken(userName);
    }
    
}
