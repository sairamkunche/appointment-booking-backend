package com.project.appointmentbooking.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ResponceBody<T> {
    public String status;
    public T data;

}
