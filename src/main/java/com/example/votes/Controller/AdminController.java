package com.example.votes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.votes.Model.Admin;
import com.example.votes.Services.AdminService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired

    private AdminService as;
  
    @GetMapping("Admin")
    public List<Admin> getcand(){
        return as.getadmin();
        
    }

    @PostMapping("addadmin")
    public String getvoter(@RequestBody Admin a){
        return as.addAdmin(a);
    }
    
 @PostMapping("Adminlogin")
 @CrossOrigin(origins = "http://localhost:4200/")
    public boolean login(@RequestBody Admin a) {
        return as.authenticateadmin(a.getAdminID(), a.getPassword());
    }
    

    

    
}
