package com.example.votes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.votes.Model.Candidate;
import java.util.List;


@Repository
public interface CandidateRepo extends JpaRepository <Candidate,Long> {

    // Candidate findByC_id(long c_id);
    
}