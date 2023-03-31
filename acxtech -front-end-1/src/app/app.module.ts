import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { FormsModule } from '@angular/forms';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { UserServicesService } from './services/user-services.service';
import { UserHomeComponent } from './components/user-home/user-home.component';
import { UserHomeHeaderComponent } from './components/user-home-header/user-home-header.component';
import { HomeHeaderComponent } from './components/home-header/home-header.component';
import { CandidateFormComponent } from './components/candidate-form/candidate-form.component';
import { CandidateDetailsComponent } from './components/candidate-details/candidate-details.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    AboutComponent,
    RegistrationComponent,
    UserHomeComponent,
    UserHomeHeaderComponent,
    HomeHeaderComponent,
    CandidateFormComponent,
    CandidateDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FormsModule,
    CommonModule
  ],
  providers: [UserServicesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
