package com.example.votes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.votes.Model.Voter;
import com.example.votes.Services.VoterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/voter")
public class VoterController {
    @Autowired

    private VoterService vrs;

@GetMapping("getvoter")
public List<Voter> getMethodName() {
    return vrs.getvoter();
}



    @PostMapping("voteradd")
    public String postMethodName(@RequestBody Voter v) {
       
        
        return vrs.addvoter(v);
    }
    
    
    @PostMapping("/login")
    public boolean login(@RequestBody Voter voter) {
        return vrs.authenticateVoter(voter.getVotername(), voter.getPassword());
    }
    
    @PostMapping("/authenticate")
    @CrossOrigin(origins = "http://localhost:4200/")
    public Boolean postMethodNamedcd(@RequestBody Voter voter) {
       return vrs.authentication(voter.getVoterID());
        
       
    }
    
}
