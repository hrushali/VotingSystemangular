package com.example.votes.Model;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Admin")
@Getter
@Setter
public class Admin {
   
    @Id
    private long adminID;
    private String adminname;
    private String password;

    public Admin(long adminID, String adminname, String password, LeadAdmin la) {
        this.adminID = adminID;
        this.adminname = adminname;
        this.password = password;
        // La = la;
    }

  
  
    
   
    @Override
    public String toString() {
        return "Admin [adminID=" + adminID + ", adminname=" + adminname + ", password=" + password + "]";
    }





    public Admin() {}

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name="Lid")
    // @JsonBackReference(value ="admin")
    // private LeadAdmin La;

 

    
}
