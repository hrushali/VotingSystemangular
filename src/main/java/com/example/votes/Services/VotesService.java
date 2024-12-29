package com.example.votes.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.votes.Model.Voter;
import com.example.votes.Model.Votes;
import com.example.votes.Repository.VoterRepo;
import com.example.votes.Repository.VotesRepo;

@Service
public class VotesService {
    @Autowired

    private VotesRepo vr;
@Autowired
private VoterRepo vor;
    

    public List<Votes> getvotes(){
        return vr.findAll();
    }
    public String addVoter(Votes vote){
        vr.save(vote);
        return "";

    }
    public String deletevoter(Votes vote){
        vr.save(vote);
        return "votes deleted";
    }

    public String addVote(Votes vote) {
        vr.save(vote);
        return "Vote added successfully";
    }

   public boolean findvoter(String voterID){

    Voter voter= vor.findByVoterID(voterID);

    // return voter != null;

     if(voter==null){
        return false;
     }else{
        return true;
     }



   }
public boolean onceVotes(String voterID) {


    Votes existingVoter = vr.findByVoter_VoterID(voterID);
    System.out.println(existingVoter+"this is existing voterid");
    if (existingVoter != null) {
     //sapdla jato
        return true;
    }
   
    return false;
}

public long getVoterCountByCId(Long c_id) {
    return vr.countByCId(c_id);
}

public List<Map<String, Object>> getVotesGroupedByCandidate() {
    List<Object[]> results = vr.getVotesGroupedByCandidate();
    List<Map<String, Object>> response = new ArrayList<>();

    for (Object[] result : results) {
        Map<String, Object> data = new HashMap<>();
        data.put("candidateId", result[0]);
        data.put("voteCount", result[1]);
        response.add(data);
    }

    return response;
}


}

