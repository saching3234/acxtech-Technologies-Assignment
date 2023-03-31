import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CandidateServiceService } from 'src/app/services/candidate-service.service';

@Component({
  selector: 'app-candidate-form',
  templateUrl: './candidate-form.component.html',
  styleUrls: ['./candidate-form.component.css']
})
export class CandidateFormComponent implements OnInit {

  canData:any;

  userFile:any;
  constructor(private canServ:CandidateServiceService,private router:Router) {

   }

  ngOnInit(): void {
  }

  //method for getting the selected image
  onSelectedFile(event:any){
    const file=event.target.files[0];
    this.userFile=file;
    console.log(this.userFile);
  }

  //method for saving the candidate details in the backend
  submit(addNew){
    this.canData=addNew.value
       //setting the image name
    this.canData.img_name=this.userFile.name
    const formData=new FormData();
    formData.append("candidate",JSON.stringify(this.canData));
    formData.append("file",this.userFile);
  
    console.log("form data before submitting : ",formData.get("candidate"));  
    
    
    //calling the service method
    this.canServ.saveCandidate(formData).subscribe(res=>{
      alert("Candidate details saved successfully");
      this.router.navigateByUrl('/candidatedetails');
    },
    
    err=>{
      if(err.status==500)
      alert("Please select the image of size greater than 5 kb and less than 1 mb")
      console.log("Error while saving the candidate",err.status);
    }
    );
    
  }
} 
