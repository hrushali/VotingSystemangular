package com.example.votes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.votes.Model.LeadAdmin;

@Repository
public interface LeadRepo extends JpaRepository<LeadAdmin,Long> {

    
}
