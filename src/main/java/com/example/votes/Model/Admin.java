package com.example.votes.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @Override
    public String toString() {
        return "Admin [adminID=" + adminID + ", adminname=" + adminname + ", password=" + password + "]";
    }
   
    
    public Admin(int adminID, String adminname, String password) {
        this.adminID = adminID;
        this.adminname = adminname;
        this.password = password;
    }

    public Admin() {
    }
 

    
}
