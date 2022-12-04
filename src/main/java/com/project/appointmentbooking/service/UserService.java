package com.project.appointmentbooking.service;

import com.project.appointmentbooking.entity.Users;
import com.project.appointmentbooking.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRespository userRespository;

    public Users createUser(Users user) {
        Users save = userRespository.save(user);
        return save;
    }

    public Users login(String email, String password) {
        Users save = userRespository.findUsersByEmailAndAndPassword(email,password);
        return save;
    }
}
