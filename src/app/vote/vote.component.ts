import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-vote',
  imports: [CommonModule,ReactiveFormsModule,RouterLink],
  templateUrl: './vote.component.html',
  styleUrl: './vote.component.scss'
})
export class VoteComponent implements OnInit {

  clist : any[] =[];

  constructor(private http:HttpClient){}

  ngOnInit(): void {
    this.getcandidate();
  }

  getcandidate(){

    this.http.get("http://localhost:8080/candidates/getcand").subscribe((response:any)=>{

      this.clist=response;

    })
  }

}
