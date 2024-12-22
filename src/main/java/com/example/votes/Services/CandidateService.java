package com.example.votes.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.votes.Model.Candidate;
import com.example.votes.Repository.CandidateRepo;
@Service
public class CandidateService {

    @Autowired

    private CandidateRepo cr;

    public List<Candidate> getcandidate(){
        
        return cr.findAll();
    }
    

    public String AddCandidates( Candidate candidate){
         cr.save(candidate);
         return "Candidate added successfully";
    }
    public String DeleteCandidtae(long c_id){
        if (cr.existsById(c_id)) {
            cr.deleteById(c_id);
            return "candidate removed successfully";
        } else {
            return "candidate not found";
        }
    }


}
