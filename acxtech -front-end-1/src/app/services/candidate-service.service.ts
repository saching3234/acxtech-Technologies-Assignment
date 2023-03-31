import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CandidateServiceService {

 
  private url="http://localhost:8080/";
  private token;

  constructor(private http:HttpClient) { 
    //getting the locally saved admin token 
    this.token="Bearer "+localStorage.getItem("token");  
  }

  //method for getting the candidate details o
   getCandidateDetails(){
        
        console.log(this.token);
        let headers=new HttpHeaders().set('Authorization',this.token);
        return this.http.get(this.url+"candidate",{headers});
   }
          

    //method for saving the candidate details details
    saveCandidate(canDetails){
      console.log("token from save candidate")  
      console.log(this.token);     
    let headers=new HttpHeaders().set('Authorization',this.token);      
      return this.http.post(this.url+"candidate",canDetails,{headers});       
    }

  
    }     
