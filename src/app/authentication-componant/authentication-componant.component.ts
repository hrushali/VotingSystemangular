import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterLink ,Router} from '@angular/router';

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

  constructor(private http:HttpClient,private router:Router){}

  ngOnInit(): void {
      
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


