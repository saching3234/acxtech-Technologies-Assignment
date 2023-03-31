import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { UserServicesService } from 'src/app/services/user-services.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  user= {userName: '', password: ''};
  res:any;

  constructor(private router:Router,private userService:UserServicesService,private auth:AuthServiceService) { }

  ngOnInit(): void {
  }

  submit(userLogin:any){

   // console.log("User Form now",userLogin.value);
   
  this.user.userName=userLogin.value.userName;
  this.user.password=userLogin.value.password; 
  console.log(this.user);
  
  //calling the service
   this.userService.checkLogin(this.user).subscribe(res=>{
    //saving the response into the class member
    this.res=res;
    //console.log("Reponse from api");
    console.log(this.res.token);

    //saving the token,user Id, User name into the local storage
    localStorage.setItem("token",this.res.token);
  
    localStorage.setItem("userName",this.user.userName);
    localStorage.setItem("isUserLoggedIn","true");
    //set is logged in service variable to true
    this.auth.isLoggedIn=true;
    //navigating the userHome page
    this.router.navigateByUrl('/userHome');
     },
     //if login not successfull then below code will execute
    err=>{
      //console.log("error from server:")
      //console.log(err);
      if(err.status==401)
      alert(err.error.errorMessage);     
      
    }
    );   

    
   }  

  //navigate to user registration page 
  register(){
   this.router.navigate(['./register']);
  

  }

}
