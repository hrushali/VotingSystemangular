package com.example.votes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.votes.Model.contactfor;
import com.example.votes.Services.contactForService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/query")
public class contactForcontroller {
    @Autowired

    private contactForService crs;

    @GetMapping("getq")
    public List<contactfor> getMethodName() {
        return crs.getcontactfor() ;
    }
    
    @PostMapping("addq")
    public String postMethodName(@RequestBody contactfor cf) {
        
       return crs.addcontactfor(cf);
    }

    @DeleteMapping("delete/{id}")
    public String deletecontact(@PathVariable long id){
        return crs.deletecontantfor(id);

    }
    
    
}
