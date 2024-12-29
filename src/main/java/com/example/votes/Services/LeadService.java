package com.example.votes.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.votes.Model.LeadAdmin;
import com.example.votes.Repository.LeadRepo;

@Service
public class LeadService {
    @Autowired

    private LeadRepo lr;

    public List<LeadAdmin> getleadadmin(){

        return lr.findAll();
        
    }
    public String Addleadadmin(LeadAdmin la){
        lr.save(la);
        return "add sucessfully";
    }
    
}
