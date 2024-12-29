package com.example.votes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.votes.Model.Votes;
import java.util.List;




@Repository
public interface VotesRepo extends JpaRepository<Votes,Long> {

    // boolean existsByVoter_VoterID(String voterID);

    // boolean findByVoterID(String voterID);

    @Query("SELECT v FROM Votes v WHERE v.voter.voterID = :voterID")
    Votes findByVoter_VoterID(String voterID);

    @Query("SELECT COUNT(v) FROM Votes v where v.candidate.c_id=: c_id")
    long countByCId(@Param("c_id") Long c_id);

    @Query(value = "SELECT c_id, COUNT(*) FROM votes GROUP BY c_id", nativeQuery = true)
    List<Object[]> getVotesGroupedByCandidate();
    
    


    
} 
