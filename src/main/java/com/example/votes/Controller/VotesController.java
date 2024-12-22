package com.example.votes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.votes.Model.Votes;
import com.example.votes.Services.VotesService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/votes")
public class VotesController {
    @Autowired
    private VotesService vs;

    @GetMapping("v")
    public List<Votes> getMethodName() {
        return vs.getvotes();
    }
    
    
    @PostMapping("/addvotes")
    public String postMethodName(@RequestBody Votes v) {
        
        
        return vs.addVoter(v);
    }
    
}
