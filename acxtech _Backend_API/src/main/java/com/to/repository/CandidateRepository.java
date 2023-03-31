package com.to.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.to.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
       public List<Candidate> getCandidateByuid(int uid);
}
