package com.example.votes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.votes.Model.Votes;


@Repository
public interface VotesRepo extends JpaRepository<Votes,Long> {

    
} 
