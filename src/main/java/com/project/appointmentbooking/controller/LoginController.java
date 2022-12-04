package com.project.appointmentbooking.controller;

import com.project.appointmentbooking.DTO.ResponceBody;
import com.project.appointmentbooking.entity.Users;
import com.project.appointmentbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @ResponseBody
    @PostMapping("/register")
    public Users createRegister(@RequestBody Users user) {
        Users save = userService.createUser(user);
        return save;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/login/{email}/{password}")
    public ResponceBody login(@PathVariable String email, @PathVariable String password) {
        Users save = userService.login(email,password);
        if(save!=null){
            return new ResponceBody<Users>("success",save);
        }
        return new ResponceBody<Users>("fail",save);
    }

}
