import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-vote',
  imports: [CommonModule, ReactiveFormsModule, RouterLink],
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.scss']
})
export class VoteComponent implements OnInit {

  clist: any[] = [];
  dbvoter: any;
  voterID: any;

  // Define the form group
  votes = new FormGroup({
    c_id: new FormControl(),
    voterID: new FormControl(),
  });

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    // Fetch session data to get the current voterID
    const sessionurl = 'http://localhost:8080/voter/session';
    this.http.get(sessionurl).subscribe((response: any) => {
      if (response) {
        this.dbvoter = response;
        this.voterID = response.voterID;
        console.log("voterID from session:", this.voterID);
      } else {
        console.log("Response did not work");
      }
    });

    // Get candidates and update the list
    this.getvotescard();
  }

  getvotescard(): void {
    this.http.get("http://localhost:8080/candidates/getcand").subscribe((response: any) => {
      this.clist = response;
    });
  }

  selectCandidate(c_id: number): void {
    this.votes.patchValue({
      c_id: c_id, 
      voterID: this.voterID
    });
    console.log('Selected candidate:', c_id);
  }

  // Function to submit the vote
  addvotes(): void {
    if (this.votes.valid) {
      console.log("Submitting Vote with values:", this.votes.value);

      // POST the vote to the backend
      const urlvotes = "http://localhost:8080/votes/addvotes";
      this.http.post(urlvotes, this.votes.value).subscribe({
        next: (result: any) => {
          console.log("Vote successfully added:", result);
        },
        error: (error) => {
          console.error("Error while adding vote:", error);
        }
      });
    } else {
      console.error('Form is not valid.');
    }
  }
}
