package com.example.votes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.votes.Model.Candidate;

@Repository
public interface CandidateRepo extends JpaRepository <Candidate,Long> {

    
}