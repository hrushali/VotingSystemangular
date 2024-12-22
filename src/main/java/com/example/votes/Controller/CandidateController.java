package com.example.votes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.votes.Model.Candidate;
import com.example.votes.Services.CandidateService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired

    private CandidateService cs;

    @GetMapping("getcand")
    public List<Candidate> getMethodName() {
        return cs.getcandidate();
    }

    @PostMapping("cand/addcand")
    public String postMethodName(@RequestBody Candidate c) {
       System.out.println(c);
        return cs.AddCandidates(c);
    }
    
    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public String deleteecand(@PathVariable int id ){
        return cs.DeleteCandidtae(id);
    }

    
}
