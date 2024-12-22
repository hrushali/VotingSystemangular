package com.example.votes.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="votes")
@Getter
@Setter
public class Votes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vote_ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voterID", referencedColumnName = "voterID") 
    @JsonBackReference(value = "voter-votes")
    private Voter voter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id", referencedColumnName = "c_id")
    @JsonBackReference(value = "candidate-votes")
    private Candidate candidate; 

    public Votes() {
    }

   
    @Override
    public String toString() {
        return "Votes []";
    }


    public Votes( Voter voter, Candidate candidate) {
        this.vote_ID = vote_ID;
        this.voter = voter;
        this.candidate = candidate;
    }

 
}
