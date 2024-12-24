import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterLink ,Router} from '@angular/router';
import { response } from 'express';

@Component({
  selector: 'app-authentication-componant',
  imports: [RouterLink,CommonModule,ReactiveFormsModule],
  templateUrl: './authentication-componant.component.html',
  styleUrl: './authentication-componant.component.css'
})
export class AuthenticationComponantComponent implements OnInit {
logingerror:any;
  voter= new FormGroup({
voterID : new FormControl(),

  })

  dbvoter:any;
  voterID:any;

  constructor(private http:HttpClient,private router:Router){}

  ngOnInit(): void {

    const sessionurl = 'http://localhost:8080/voter/session';

    this.http.get(sessionurl).subscribe((response:any)=>{
   if(response){
         this.dbvoter=response;
        this.voterID=response.voterID;
        console.log("respose for id",this.voterID)
         console.log(response,"from response");
   }else{
    console.log("response not work");
   }


    })



      
  }

  getauthentication(){

    const url = 'http://localhost:8080/voter/authenticate';

    console.log('Login attempt with:', this.voter.value);

    this.http.post<boolean>(url, this.voter.value).subscribe(
      (response) => {
        if (response) {
          console.log('Login successful!');

          this.router.navigate(['/vote1'])
         

        } else {


          this.logingerror="Invalid voter ID or password."

          console.log('Invalid voter ID or password.');
        }
      },
      (error) => {
        console.error('Login failed due to an error:', error);
      }
    );
  }

      
   
  }


