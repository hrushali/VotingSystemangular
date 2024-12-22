package com.example.votes.Repository;

import com.example.votes.Model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long>{
    Admin findByAdminIDAndPassword(long adminID, String password);


}
