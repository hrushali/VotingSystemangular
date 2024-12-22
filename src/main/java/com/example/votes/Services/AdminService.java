package com.example.votes.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.votes.Model.Admin;
import com.example.votes.Repository.AdminRepo;

@Service
public class AdminService {
    @Autowired

    private AdminRepo ar;


    public List<Admin> getadmin(){
        return ar.findAll();
    }

    public String addAdmin(Admin admin){
        ar.save(admin);
        return "successfully added";
    }



      public boolean authenticateadmin(long adminID, String password) {
        Admin admin = ar.findByAdminIDAndPassword(adminID, password);
        return admin != null; 
    }

}

