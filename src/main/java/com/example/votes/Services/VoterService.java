package com.example.votes.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.votes.Model.Voter;

import com.example.votes.Repository.VoterRepo;

@Service
public class VoterService {
    @Autowired

    private VoterRepo vr;


    public String addvoter(@RequestBody Voter voter){
        vr.save(voter);
        return "voter successfully added";
    }
    
    public List<Voter> getvoter(){
        return vr.findAll();
    }
    
    public String deleteVoter(String voterID) {
        if (vr.existsById(voterID)) {
            vr.deleteById(voterID);
            return "Voter successfully deleted.";
        } else {
            return "Voter not found.";
        }
    }

    public boolean authenticateVoter(String votername, String password) {
        Voter voter = vr.findByVoternameAndPassword(votername, password);
        return voter != null; 
    }


    public boolean authentication(String voterID){
         Voter voter= vr.findByVoterID(voterID);
         return voter != null;
    }
    
}
    

