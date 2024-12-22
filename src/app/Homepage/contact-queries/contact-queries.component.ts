import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterLink,Router } from '@angular/router';

@Component({
  selector: 'app-contact-queries',
  imports: [RouterLink,ReactiveFormsModule],
  templateUrl: './contact-queries.component.html',
  styleUrl: './contact-queries.component.css'
})
export class ContactQueriesComponent implements OnInit{

  contact = new FormGroup({
Massage:new FormControl(),
subject: new FormControl(),
  });
  constructor(private http:HttpClient,private router:Router){}
  ngOnInit(): void {
      
  }

  getqueries(){

    this.http.post("http://localhost:8080/query/addq",this.contact.value).subscribe((response:any)=>{
    })

  

   

  }

}
