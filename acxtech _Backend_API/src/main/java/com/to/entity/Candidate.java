package com.to.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Candidate {
	@Id
	//defining the sequence 
	@SequenceGenerator(
			name = "candidate_sequence",
			sequenceName = "candidate_sequence",
			allocationSize = 1
			)
	//give the sequence to generated value
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "candidate_sequence"
			)
    private int cid;
	private int uid;
    private String cname;
    private String mobileNo;
    private String address;
    private String skills;
    private String hobbies;
    private String photoPath;
    private String img_name;
}
