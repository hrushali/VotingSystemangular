package com.example.votes.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.votes.Model.contactfor;
import com.example.votes.Repository.contactforRepo;

@Service
public class contactForService {
    @Autowired

    private contactforRepo cfr;

    public List<contactfor> getcontactfor(){
        return cfr.findAll();
        
    }

    public String  addcontactfor(contactfor cf){
    cfr.save(cf);
    return "query successfully submitted";
    }
    
    public String deletecontantfor(long cfid){
        if (cfr.existsById(cfid)) {
            cfr.deleteById(cfid);
            return "candidate removed successfully";
        } else {
            return "candidate not found";
        }
    }
}
