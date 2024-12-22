package com.example.votes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.votes.Model.Voter;
import java.util.List;


@Repository
public interface VoterRepo extends JpaRepository<Voter,String>{
    Voter findByVoternameAndPassword(String votername, String password);

    Voter  findByVoterID(String voterID);
    
} 
