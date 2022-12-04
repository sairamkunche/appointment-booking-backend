package com.project.appointmentbooking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private long id;
    private String email;
    private String bookingId;
    private String dateTime;
    private String companyName;
    private String companyAddress;
}
