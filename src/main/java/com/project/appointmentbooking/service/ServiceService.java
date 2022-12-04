package com.project.appointmentbooking.service;

import com.project.appointmentbooking.DTO.AppointmentDto;
import com.project.appointmentbooking.email.EmailService;
import com.project.appointmentbooking.entity.*;
import com.project.appointmentbooking.repository.AppointmentsRepository;
import com.project.appointmentbooking.repository.ServiceRepository;
import com.project.appointmentbooking.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    AppointmentsRepository appointmentsRepository;

    @Autowired private EmailService emailService;

    public ServiceType createServiceType(ServiceType serviceType) {
        ServiceType save = serviceTypeRepository.save(serviceType);
        return save;
    }

    public ServiceLocation addService(ServiceLocation serviceLocation) {
        ServiceLocation save = serviceRepository.save(serviceLocation);
        return save;
    }

    public List<String> getServicesNames(String locationName) {
        List<String> save = serviceRepository.getDistinctService(locationName);
        return save;
    }
    public  List<ServiceLocation> getServices(String locationName,String serviceName) {
        List<ServiceLocation> save = serviceRepository.getServiceLocationByLocationAndService(locationName,serviceName);
        return save;
    }

    public  List<ServiceLocation> getAllServices() {
        List<ServiceLocation> save = serviceRepository.findAll();
        return save;
    }

    public ServiceLocation getServiceById(long id) {
        Optional<ServiceLocation> save = serviceRepository.findById(id);
        return save.get();
    }


    public Appointments bookAppointment( Appointments appointments) {
        Appointments save = appointmentsRepository.save(appointments);

        EmailDetails details = new EmailDetails();
        details.setRecipient(appointments.getEmail());
        details.setSubject("Your Appointment is scheduled");
        details.setMsgBody("you have an appointment at " + appointments.getDateTime());
        String status
                = emailService.sendSimpleMail(details);
        return save;
    }

    public  List<AppointmentDto> fetchAppointmentsForUsers(String email){
        List<Appointments> appointmentsList=appointmentsRepository.findAppointmentsByEmail(email);
        List<AppointmentDto> appointmentDtos=new ArrayList<>();
        appointmentsList.forEach(appointments -> {
            ServiceLocation save = serviceRepository.findById(Long.parseLong(appointments.getBookingId())).get();
            appointmentDtos.add(new AppointmentDto(appointments.getId(),appointments.getEmail(),appointments.getBookingId(),appointments.getDateTime(),save.getCompanyName(),save.getAddress()));
        });
        return appointmentDtos;
    }

}
