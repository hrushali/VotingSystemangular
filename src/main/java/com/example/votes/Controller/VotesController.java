package com.example.votes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.votes.Model.Candidate;
import com.example.votes.Model.Voter;
import com.example.votes.Model.Votes;
import com.example.votes.Services.CandidateService;
import com.example.votes.Services.VoterService;
import com.example.votes.Services.VotesService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/votes")
public class VotesController {
    @Autowired
    private VotesService vs;

    private VoterService vrs;

    private CandidateService cs;

    private Votes dbvotes;

    @GetMapping("v")
    public List<Votes> getMethodName() {
        return vs.getvotes();
    }
    
    
    @PostMapping("/addvotes")
    public String postMethodName(@RequestBody Votes v) {
        
        
        return vs.addVoter(v);
    }


    @DeleteMapping("/deletevoter")
    public String deletemethod(@RequestBody Votes vote){
        return vs.deletevoter(vote);
    }

//    @PostMapping("/addvotes")
//     public ResponseEntity<String> addVote(@RequestBody Votes voteRequest) {
//         // Fetch Voter and Candidate by their IDs
//         Voter voter = vrs.findById(voteRequest.getVoter().getVoterID());
//         Candidate candidate = cs.findById(voteRequest.getCandidate().getC_id());

//         if (voter == null || candidate == null) {
//             return ResponseEntity.badRequest().body("Voter or Candidate not found");
//         }

//         // Set the Voter and Candidate to the Votes object
//         Votes vote = new Votes(voter, candidate);

//         // Save the vote
//         vs.addVoter(vote);

//         return ResponseEntity.ok("Vote added successfully");
//     }
}


