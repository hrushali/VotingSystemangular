package com.example.votes.Model;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="LeadAdmin")
@Getter
@Setter
public class LeadAdmin {
    @Id
    private long Lid;
    private String Name; 
    private String password;



@Override
    public String toString() {
        return "LeadAdmin [Lid=" + Lid + ", Name=" + Name + ", password=" + password +  "]";
    }

public LeadAdmin(long lid, String name, String password, List<Admin> alist) {
        Lid = lid;
        Name = name;
        this.password = password;
        // Alist = alist;
    }



// @OneToMany(cascade = CascadeType.ALL,mappedBy = "La")
// @JsonManagedReference(value = "admin")
// private List<Admin> Alist;

public LeadAdmin() {
}
    
}
