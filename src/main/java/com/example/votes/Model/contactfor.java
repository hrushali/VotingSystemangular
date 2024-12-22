package com.example.votes.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
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
@Table(name="contact")
@Getter
@Setter
public class contactfor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactID;
    private String subject;
    private String Massage;

    @Override
    public String toString() {
        return "contactfor [contactID=" + contactID + ", subject=" + subject + ", Massage=" + Massage + ", v=" + v
                + "]";
    }

    public contactfor() {
    }

   
    public contactfor(long contactID, String subject, String massage, Voter v) {
        this.contactID = contactID;
        this.subject = subject;
        Massage = massage;
        this.v = v;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="voterID")
    @JsonBackReference
    private Voter v;
    
}
