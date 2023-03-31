package com.to.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.to.entity.Candidate;
import com.to.entity.User;
import com.to.repository.CandidateRepository;
import com.to.repository.UserRepository;

@Service
public class CandidateServiceImpl {
	@Autowired
	CandidateRepository candidateRepository;
	@Autowired
	UserRepository userRepository;
	
	public Candidate saveCandidate (Candidate candidate) {
	  return candidateRepository.save(candidate);
	}

	public List<Candidate> getCandidates(String userName) {
	  int uid=getCurrentUserId(userName);
		return candidateRepository.getCandidateByuid(uid);
	}
	
	public int getCurrentUserId(String userName) {
		   //finding the uid using the userName;
				User user=userRepository.findByUserName(userName);
				
				return user.getId();
	}

}
