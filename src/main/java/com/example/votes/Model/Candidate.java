package com.example.votes.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="Candidate")
@Getter
@Setter
public class Candidate {
    @Id
    private long c_id;
    private String C_name;
    private String partyname;

    @Override
    public String toString() {
        return "Candidate [c_id=" + c_id + ", C_name=" + C_name + ", partyname=" + partyname + ", votelist=" + votelist
                + "]";
    }




public Candidate() {
    }

@OneToMany(cascade = CascadeType.ALL, mappedBy = "candidate")
@JsonManagedReference(value = "candidate-votes")  // Matching identifier
private List<Votes> votelist = new ArrayList<>();

public Candidate(int c_id, String c_name, String partyname, List<Votes> votelist) {
    this.c_id = c_id;
    this.C_name = c_name;
    this.partyname = partyname;
    this.votelist = votelist;
}

// @OneToMany(mappedBy = "candidates", cascade = CascadeType.ALL)
// @JsonManagedReference
// private List<Voter> voters = new ArrayList<>();

    
  
    // this.voters = voters;

    
}
