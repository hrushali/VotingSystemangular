package com.example.votes.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.votes.Model.Votes;
import com.example.votes.Repository.VotesRepo;

@Service
public class VotesService {
    @Autowired

    private VotesRepo vr;

    public List<Votes> getvotes(){
        return vr.findAll();
    }
    public String addVoter(Votes vote){
        vr.save(vote);
        return "votes added";

    }

    
    
}
