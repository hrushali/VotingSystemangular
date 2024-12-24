import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule} from '@angular/forms';
import { RouterLink} from '@angular/router';

@Component({
  selector: 'app-contact-queries',
  imports: [RouterLink,ReactiveFormsModule,CommonModule],
  templateUrl: './contact-queries.component.html',
  styleUrl: './contact-queries.component.css'
})
export class ContactQueriesComponent implements OnInit{

  contact = new FormGroup({
massage:new FormControl(),
subject: new FormControl(),
  });


  constructor(private http:HttpClient){}


  ngOnInit() {
      
  }
 

  getqueries():void{
const url = "http://localhost:8080/query/addq";
    this.http.post(url,this.contact.value).subscribe((response:any)=>{
   
    })

  }

}