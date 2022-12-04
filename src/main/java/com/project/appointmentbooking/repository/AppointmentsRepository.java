package com.project.appointmentbooking.repository;

import com.project.appointmentbooking.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentsRepository extends JpaRepository<Appointments,Long> {


    List<Appointments> findAppointmentsByEmail(String email);
}
