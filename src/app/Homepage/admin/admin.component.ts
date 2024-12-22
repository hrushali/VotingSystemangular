import { CommonModule, UpperCasePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-admin',
  imports: [CommonModule,RouterLink,UpperCasePipe],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent implements OnInit {


  clist: any[]=[];

  constructor(private http:HttpClient){

  }
  ngOnInit() {
    this.getcandidate();
  }


  reloadPage(): void {
    window.location.reload(); // This will reload the entire page
  }
  getcandidate(){

   this.http.get("http://localhost:8080/candidates/getcand").subscribe((result:any)=>{

    this.clist=result;

   })
  }
  deletecandidate(c_id:any) {
    const baseURL = "http://localhost:8080/candidates/delete";
    this.http.delete(baseURL + "/" + c_id).subscribe((response)=>{
      console.log(response);
      this.getcandidate();
    }, error => {
      console.log("some error is comming" + error);
    })
  }


}
