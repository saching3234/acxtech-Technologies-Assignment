import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { CandidateServiceService } from 'src/app/services/candidate-service.service';

@Component({
  selector: 'app-candidate-details',
  templateUrl: './candidate-details.component.html',
  styleUrls: ['./candidate-details.component.css']
})
export class CandidateDetailsComponent implements OnInit {

  
  canDetails:any;
   

  
  constructor(private candidateService:CandidateServiceService,private sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.userDetails();
  }

  public getSantizeUrl(url : string) {
    return this.sanitizer.bypassSecurityTrustUrl(url);
}
  
  
  //method for fetching the candidate from server
  userDetails(){
    this.candidateService.getCandidateDetails().subscribe(res=>{
      this.canDetails=res;
      //for(let can of this.canDetails)
      //console.log("The details of the candidate is :"+can.cid);
    },

    err=>{
       //console.log("Error while fetching the candidate details: "+err);
    }
  )
  }
  
 
  
} 