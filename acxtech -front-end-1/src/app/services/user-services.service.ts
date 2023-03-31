import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserServicesService {
  private url="http://localhost:8080";
  

  constructor(private httpClient:HttpClient) { }

  
  
 

  //method for login the user
  checkLogin(user:any){
  console.log(user)
  return this.httpClient.post(this.url+'/login',user);
  }

  //method for register the user
  registerUser(user:any){
    console.log("register user service method called :",user);
    return this.httpClient.post(this.url+'/register',user);
  } 

}
