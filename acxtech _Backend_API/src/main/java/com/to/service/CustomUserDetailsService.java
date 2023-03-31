package com.to.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.to.entity.User;
import com.to.error.UserIdAllReadyExist;
import com.to.repository.UserRepository;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
    
    //method for saving the new userdetails in the db
    public User registerUser(User user) throws UserIdAllReadyExist {
    	//first check the user is  already exist or not
    	User dbUser=repository.findByUserName(user.getUserName());
    	if(dbUser!=null) {
    		throw new UserIdAllReadyExist("User Id Allready taken please try with other usere id......");
    	}
    	
    	else {
		      //saving the new user details in db
    	  return repository.save(user);
		}
    	
    }
}
