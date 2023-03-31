import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {
token:any;
userId:any;
userName:any;
categories:any;

 constructor(private router:Router) { }

  ngOnInit(): void {
   this.token= localStorage.getItem("token");
   //navigate to login page if token is empty
   if(this.token==null){
    this.router.navigate(['/']);
   }
    this.userId=localStorage.getItem("userId");
   this.userName= localStorage.getItem("userName");
   
  }

  



}
