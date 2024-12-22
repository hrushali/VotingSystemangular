package com.example.votes.Model;

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
@Table(name="voter")
@Getter
@Setter
public class Voter {
    @Id
    private String voterID;  
    private String votername;
    private String password;
    private String createAt;


   @Override
    public String toString() {
        return "Voter [voterID=" + voterID + ", votername=" + votername + ", password=" + password + ", createAt="
                + createAt +  "]";
    }















public Voter(String voterID, String votername, String password, String createAt, List<Votes> votesl) {
    this.voterID = voterID;
    this.votername = votername;
    this.password = password;
    this.createAt = createAt;
    this.votesl = votesl;
}















@OneToMany( mappedBy = "voter")
    @JsonManagedReference(value = "voter-votes")
    private List<Votes> votesl;


    @OneToMany(mappedBy = "v",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<contactfor> clist;




//  @ManyToOne
//     @JoinColumn(name = "c_id")
//     @JsonBackReference // Avoid circular reference in JSON
//     private Candidate candidates;


public Voter() {
}


   


    
}
