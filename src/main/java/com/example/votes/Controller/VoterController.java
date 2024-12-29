package com.example.votes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.votes.Model.Voter;
import com.example.votes.Services.VoterService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/voter")
public class VoterController {
    @Autowired

    private VoterService vrs;
    private  Voter dbvoter; 

@GetMapping("getvoter")
public List<Voter> getMethodName() {
    return vrs.getvoter();
}



    @PostMapping("voteradd")
    public Voter postMethodName(@RequestBody Voter v) { 
        
        return vrs.addvoter(v);
    }

@PutMapping("updatevoter/{id}")
public String putMethodName(@PathVariable String id, @RequestBody Voter voter) {
   
    
    return vrs.updateVoter(voter);
}
    
@DeleteMapping("/deletevoter/{id}")
public String deletedvotermethod(@PathVariable String id){
    return vrs.deleteVoter(id);
}



    
    @PostMapping("/login")
    public Voter login(@RequestBody Voter voter) {
        
        Voter hrush= vrs.authenticateVoter(voter.getVotername(), voter.getPassword());

        // Voter voter1 = vrs.addvoter(voter);
       
        if(hrush!=null){
            dbvoter=hrush;
            // return true;
            return dbvoter;
        }else{
            // System.out.println("Login unsuccessfull");
        return null;
                // return false;
        }
        
        
    }

    @GetMapping("session")
    public Voter postsession() {

        System.err.println("run dbvoter is running sucessfully "+dbvoter);
        return dbvoter;
    }
    
    
    @PostMapping("/authenticate")
    @CrossOrigin(origins = "http://localhost:4200/")
    public Boolean postMethodNamedcd(@RequestBody Voter voter) {
       return vrs.authentication(voter.getVoterID());
        
       
    }

     


}

    
