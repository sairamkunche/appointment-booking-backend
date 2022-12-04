package com.project.appointmentbooking.email;

import com.project.appointmentbooking.entity.EmailDetails;

public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

}