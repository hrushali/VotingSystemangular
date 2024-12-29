package com.example.votes.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.votes.Model.Votes;

import com.example.votes.Services.VotesService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/votes")
public class VotesController {
    @Autowired
    private VotesService vs;

   

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

    @PostMapping("/oncevote") 
    public boolean postMethodNameg(@RequestBody String voterid) {
      
        System.out.println("after Hrushh"+ voterid);

    if(vs.onceVotes(voterid)){
        System.out.println("sapdla vote nahi honar");
        return true;
    }else{
        System.out.println("nahi sapdla vote hoil");
        return false;
    }
    
    }

    @GetMapping("/countByCId/{c_id}")
    public long getVoterCountByCId(@PathVariable Long c_id) {
        long count = vs.getVoterCountByCId(c_id);
        return count;
    }

    @GetMapping("/grouped-by-candidate")
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseEntity<List<Map<String, Object>>> getGroupedVotes() {
        List<Map<String, Object>> groupedVotes = vs.getVotesGroupedByCandidate();
        return ResponseEntity.ok(groupedVotes);
    }


}


