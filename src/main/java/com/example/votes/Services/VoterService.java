package com.example.votes.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.votes.Model.Voter;

import com.example.votes.Repository.VoterRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class VoterService {
    @Autowired

    private VoterRepo vr;


    public Voter addvoter(@RequestBody Voter voter){
        vr.save(voter);
        return voter;
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

public String updateVoter(Voter voter){
    if(vr.existsById(voter.getVoterID())){
        vr.save(voter);
        return "Voter update successfully";
    }
    else{
        return "voter not found";
    }

}



    public Voter authenticateVoter(String votername, String password) {

        Voter voter = vr.findByVoternameAndPassword(votername, password);
        
        return voter; 
    }


    public boolean authentication(String voterID){
         Voter voter= vr.findByVoterID(voterID);
         return voter != null;
    }

    
    
}
    

