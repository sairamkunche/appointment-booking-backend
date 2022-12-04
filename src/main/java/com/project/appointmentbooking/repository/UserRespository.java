package com.project.appointmentbooking.repository;

import com.project.appointmentbooking.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<Users,String> {

    Users findUsersByEmailAndAndPassword(String email, String password);


}

