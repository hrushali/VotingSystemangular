package com.example.votes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.votes.Model.LeadAdmin;
import com.example.votes.Services.LeadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/Lead")
public class LeadController {
    @Autowired

    private LeadService ls;

    @GetMapping("getlead")
    public List<LeadAdmin> getMethodName() {
        return ls.getleadadmin();
    }

    @PostMapping("/addlead")
    public String postMethodName(@RequestBody LeadAdmin la) {
        return ls.Addleadadmin(la);
    }
    
    
    
}
