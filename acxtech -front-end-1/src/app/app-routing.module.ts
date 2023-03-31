import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { CandidateDetailsComponent } from './components/candidate-details/candidate-details.component';

import { HomeComponent } from './components/home/home.component';

import { RegistrationComponent } from './components/registration/registration.component';
import { UserHomeComponent } from './components/user-home/user-home.component';


const routes: Routes = [
{path:'' ,component:HomeComponent},
{path:'about',component:AboutComponent},
{path:'register', component:RegistrationComponent},
{path:'userHome',component:UserHomeComponent},

{path:'candidatedetails',component:CandidateDetailsComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
